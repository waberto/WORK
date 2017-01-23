theory jules
imports Main 
begin

datatype digit = Zero | Uno
type_synonym bin = "digit list"

(* exam seconde session 2013/2014*)
fun powmaison :: "nat \<Rightarrow> nat \<Rightarrow> nat"
where
"powmaison nombre 0 =  1" |
"powmaison 0 a = 0" |
"powmaison a b =  a * (powmaison a (b - 1))"

value "(powmaison 2 2)"

(*

fun bin2natAux::"bin \<Rightarrow> nat \<Rightarrow> nat"
where
(* 1 0 1 = 5*)
 "bin2natAux [] res = res " |
 "bin2natAux (e#l) res = (
 if (e = Zero) 
 then (bin2natAux l res)
 else  (bin2natAux l (res + 
          (powmaison 2 (List.length l))
        )
      )
) "

fun bin2nat::"bin \<Rightarrow> nat"
where
 "bin2nat l =  bin2natAuxInv l 0 "


*)
fun bin2natAuxInv::"bin \<Rightarrow> nat \<Rightarrow> nat"
where
(* 1 0 1 = 5*)
 "bin2natAuxInv [Zero] pow = 0 " |
 "bin2natAuxInv [Uno] pow = 1 " |
 "bin2natAuxInv (e#l) pow = (
 if (e = Zero) 
 then (bin2natAuxInv l (pow + 1))
 else  (bin2natAuxInv l (pow + 1)) + 
          (powmaison 2 pow)
      )
 "

fun nat2int::"nat \<Rightarrow> int"
where
"nat2int 0 = 0" |
"nat2int (Suc e) = 1 + (nat2int e)"

value "nat2int(bin2nat [Uno, Zero, Zero, Zero])"
value "nat2int(bin2nat [Zero, Zero, Zero, Uno])"


fun resteBin:: "nat \<Rightarrow> digit"
where 
"resteBin nb = (if (nb mod 2) = 0 then Zero else Uno)"


fun nat2binAux:: "nat \<Rightarrow> bin \<Rightarrow> bin"
where
"nat2binAux 0 bins = bins" |
"nat2binAux nombre bins = (resteBin nombre)#(nat2binAux (nombre div 2) bins)"  
  

fun nat2bin::"nat \<Rightarrow> bin"
where
"nat2bin 0 = [Zero]" |
"nat2bin (Suc 0) = [Uno]" |
"nat2bin nb = nat2binAux nb [] "


fun bin2natAux::"bin \<Rightarrow> nat \<Rightarrow> nat"
where
(* 1 0 1 = 5*)
 "bin2natAux [] res = res " |
 "bin2natAux (e#l) res = (
 if (e = Zero) 
 then (bin2natAux l res)
 else  (bin2natAux l (res + 
          (powmaison 2 (List.length l))
        )
      )
) "

fun bin2nat::"bin \<Rightarrow> nat"
where
 "bin2nat l =  bin2natAuxInv l 0 "



value "nat2bin 8"

fun addBin::"bin \<Rightarrow> bin \<Rightarrow> bin"
where
"addBin [] [] = []" | 
"addBin [] b = b" | 
"addBin b [] = b" |
"addBin (Zero#b1) (Zero#b2) = Zero#(addBin b1 b2)" |
"addBin (Uno#b1) (Zero#b2) =  Uno#(addBin b1 b2)" |
"addBin (Zero#b1) (Uno#b2) =  Uno#(addBin b1 b2)" |
"addBin (Uno#b1) (Uno#b2) =   Zero#(addBin b1 (addBin [Uno] b2))" 

definition "d1 = [Zero, Zero, Zero, Uno]"
definition "d2 = [Uno, Zero, Zero, Uno]"
definition "d3 = [Uno, Zero, Uno]"
definition "d4 = [Zero]"

value "addBin d1 d2"
value "addBin d1 d3"
value "addBin d3 d1"

value "nat2int (bin2nat (nat2bin 0))"
value "nat2int (bin2nat (nat2bin 5))"
value "nat2bin (bin2nat d1)"
value "nat2bin (bin2nat d4)"
value "bin2nat d4"

(* Toute conversion effectuee est la bonne *)



fun nat2binAux2:: "nat \<Rightarrow> bin \<Rightarrow> bin"
where
"nat2binAux2 0 bins = bins" |
"nat2binAux2 nombre bins = (resteBin nombre)#(nat2binAux2 (nombre div 2) bins)"


fun nat2bin2::"nat \<Rightarrow> bin"
where
"nat2bin2 0 = [Zero]" |
"nat2bin2 (Suc 0) = [Uno]" |
"nat2bin2 nb = List.rev (nat2binAux2 nb []) "


lemma nat2bin2Lemma:"d\<noteq>[] \<longrightarrow> ( bin2nat2 (List.rev d) = bin2nat2( nat2bin (bin2nat2 (List.rev d))))"
nitpick
sorry


(*  2e Essai  *)

fun nbdigits::"nat \<Rightarrow> nat"
where 
"nbdigits 0 = 1" |
"nbdigits (Suc 0) = 1" |
"nbdigits n = 1 + (nbdigits (n div 2))"

fun nat2binPAux :: "nat \<Rightarrow> nat \<Rightarrow> bin"
where
"nat2binPAux _ 0 = []" |
"nat2binPAux n x = (
  if (n \<ge> (powmaison 2 (x - 1)))
  then Uno#(nat2binPAux (n - (powmaison 2 (x - 1))) (x - 1))
  else Zero#(nat2binPAux (n - (powmaison 2 (x - 1))) (x - 1))
)"

fun nat2binP :: "nat \<Rightarrow> bin"
where 
"nat2binP n = nat2binPAux n (nbdigits n)"



fun bin2natP::"bin \<Rightarrow> nat"
where 
"bin2natP [Zero] = 0" |
"bin2natP [Uno] = 1" |
"bin2natP (t#q) = (bin2natP [t]) * (powmaison 2 (List.length q)) + (bin2natP q)" |
"bin2natP [] = 0"



lemma bin2natLemma:"n = bin2natP (nat2binP n)"
apply (induct n)                                             
apply auto
nitpick
sorry


lemma nat2binLemma:"d\<noteq>[] \<longrightarrow> (  d =  nat2binP (bin2natP d))"
nitpick
sorry



value "d1"
value "nat2bin2 4"
value "nat2binP 4"
value "bin2nat2 (List.rev d1)"
end
