theory tp89
imports Main (* "~~/src/HOL/Library/Code_Target_Nat" *)
begin

(* 
quickcheck_params [size=6,tester=narrowing,timeout=120]
nitpick_params [timeout=120]
*)

type_synonym transid= "nat*nat*nat"

datatype message= 
  Pay transid nat  
| Ack transid nat
| Cancel transid

type_synonym transaction= "transid * nat"

(* Les fonctions à réaliser *)
(* 1° *)
(*Transation en cours *)

datatype transBddInfo = 
    TransationEnCours "message*transid*nat"
  | TransationAnnuler "message*transid"
  | TransationValider "message*transid*nat"

type_synonym transBdd = " transBddInfo list "  

(* Fonction de validation d'une transaction après un Pay du client*)

fun traiterMessageInfo :: " message ⇒ transBddInfo ⇒ transBddInfo "
where
"traiterMessageInfo ( Pay (c,m,ident), am ) (TransationEnCours (mess, (c1,m1,ident1), am1)) = 
        (if ((Pay ((c1,m1,ident1), am1) = mess) ∧ (am > am1)) then (TransationEnCours mess,(c,m,ident), am)
        else (if ((Ack ((c1,m1,ident1) am1) = mess) ∧ (am < am1)) then (TansationValider (mess,(c,m,ident),am))
        else (if (Cancel (c1,m1,ident1) = mess) then (TransationAnnuler (mess, (c,m,ident)))
        else (TransationEnCours (mess, (c,m,ident), am)))))" |

"traiterMessageInfo (Pay (c,m,ident) am) (TransationAnnuler(mess,(c1,m1,ident1))) = (TransationAnnuler (mess,(c1,m1,ident1)))"|
"traiterMessageInfo (Pay (c,m,ident) am) (TransationValider(mess,(c1,m1,ident1) am1)) = (TransationValider (mess,(c1,m1,ident1), am1))"| 

"traiterMessageInfo ( Ack (c,m,ident) am ) (TransationEnCours(mess, (c1,m1,ident1), am1)) = 
        (if (((Ack ((c1,m1,ident1) am1)) = mess) ∧ (am > am1)) then (TransationEnCours (mess,(c,m,ident), am))
        else (if ((Pay ((c1,m1,ident1) am1) = mess) ∧ (am < am1)) then (TansationValider (mess,(c,m,ident), am))
        else (if (Cancel (c1,m1,ident1) = mess) then (TransationAnnuler (mess,(c,m,ident)))
        else (TransationEnCours (mess, (c,m,ident), am)))))"|  

"traiterMessageInfo (Ack (c,m,ident), am) (TransationAnnuler(mess,(c1,m1,ident1))) = (TransationAnnuler (mess,(c1,m1,ident1))) "|
"traiterMessageInfo (Ack (c,m,ident), am) (TransationAnnuler(mess,(c1,m1,ident1), am1)) = (TransationValider (mess,(c1,m1,ident1), am1)) "|

"traiterMessageInfo (Cancel(c,m,ident)) (TransationAnnuler (mess,(c1,m1,ident1))) = (TransationAnnuler (mess,(c1,m1,ident1)))"|
"traiterMessageInfo (Cancel(c,m,ident)) (TransationValider (mess,(c1,m1,ident1), am1)) = (TransationValider (mess,(c1,m1,ident1)))"|
"traiterMessageInfo (Cancel(c,m,ident)) (TransationEnCours (mess, (c1,m1,ident1),am1)) = (TransationValider (mess,(c1,m1,ident1)))"

(* fonction traiterMessage *)
fun traiterMessage ::  "message ⇒ transBdd ⇒ transBdd "
where
" traiterMessage  (Pay (c,m,ident) am)  [] = [(TransationEnCours (Pay (c,m,ident) am) (c,m,ident) am)] "|
" traiterMessage  (Cancel (c,m,ident))  [] = [(TransationAnnuler (Cancel (c,m,ident)))] "|
" traiterMessage  (Ack (c,m,ident) am)  [] = [(TransationEnCours (Ack (c,m,ident) am) (c, m, ident) am)]"|

" traiterMessage  (Pay (c,m,ident) am) (x#xs) = ( if (ident=x) then (traiterMessageInfo (Pay (c,m,ident) am) x)#xs
                                                  else (traiterMessage (Pay (c,m,ident) am) xs)) "|
" traiterMessage (Cancel (c,m,ident)) (x#xs) = (if (ident=x) then (traiterMessageInfo (Cancel (c,m,ident)) x)#xs
                                                else (traiterMessage (Cancel (c,m, ident)) xs)) "|
" traiterMessage (Ack (c,m,ident) am) (x#xs) = (if (ident=x) then (traiterMessageInfo (Ack (c,m,ident) am) x)#xs
                                                else (traiterMessage (Ack (c,m,ident) am) xs))"

(* construction de la liste des transactions validées à par d'une BDD *)
fun export :: "transBdd ⇒ transaction list "
where
"export [] = []"|
"export (x#xs) = (case x of (TransationValider(mess, transid, am)) ⇒ ( transid, am)#(export xs) | _ ⇒ (export xs)) "
(*"export (x#xs) = (case x of (TransationEnCours(mess, transid, am)) ⇒ (export xs) |
                    case x of (TransationAnnuler() _ ⇒ (export xs)) "*)

(* Création d'une BDD à partir d'une liste de message *)
fun traiterMessageList :: "message list ⇒ transBdd "
where
"traiterMessageList [] = []"|
"traiterMessageList (x#xs) = (case x of (Pay transid am) ⇒ (TransationEnCours ((Pay transid am), transid,am))#(traiterMessageList xs) |
                             (Ack transid am) ⇒ (TransatioEnCours((Ack transid am), transid, am))#(traiterMessageList xs) |
                              (Cancel transid) ⇒ (TransatioAnnuler transid)#(traiterMessageList xs))"


(* "traiterMessageList [] = []"|
  "traiterMessageList (x#xs) = (case x of (Pay transID am) \<Rightarrow> (TransEnCours (transID,(Pay transID am), am))#(traiterMessageList xs) |
                               (Ack transID am) \<Rightarrow> (TransEnCours (transID,(Ack transID am), am))#(traiterMessageList xs)| 
                               (Cancel transID) \<Rightarrow> (TransAnnuler transID)#(traiterMessageList xs))"
  *)


(* ----- Exportation en Scala (Isabelle 2014) -------*)

(* Directive d'exportation *)
export_code export traiterMessage in Scala



end

