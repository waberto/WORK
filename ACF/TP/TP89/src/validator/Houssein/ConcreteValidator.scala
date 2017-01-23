package validator.Houssein
import bank._


// Automatic conversion of bank.message to tp89.messages and Nat to bank.Nat
object Converter{
  implicit def bank2message(m:bank.message):tp89.message=
    m match {
    case bank.Pay((bank.Nat.Nata(c),(bank.Nat.Nata(m),bank.Nat.Nata(i))),bank.Nat.Nata(p)) => tp89.Pay((Nat.Nata(c),(Nat.Nata(m),Nat.Nata(i))),Nat.Nata(p))
    case bank.Ack((bank.Nat.Nata(c),(bank.Nat.Nata(m),bank.Nat.Nata(i))),bank.Nat.Nata(p)) => tp89.Ack((Nat.Nata(c),(Nat.Nata(m),Nat.Nata(i))),Nat.Nata(p))
    case bank.Cancel((bank.Nat.Nata(c),(bank.Nat.Nata(m),bank.Nat.Nata(i)))) => tp89.Cancel((Nat.Nata(c),(Nat.Nata(m),Nat.Nata(i))))
  }
  
  implicit def trans2bankTrans(l:List[((Nat.nat,(Nat.nat,Nat.nat)),Nat.nat)]): List[((bank.Nat.nat,(bank.Nat.nat,bank.Nat.nat)),bank.Nat.nat)]=
    l match {
    case Nil => Nil
    case ((Nat.Nata(c),(Nat.Nata(m),Nat.Nata(i))),Nat.Nata(p))::r => ((bank.Nat.Nata(c),(bank.Nat.Nata(m),bank.Nat.Nata(i))),bank.Nat.Nata(p))::trans2bankTrans(r)
  }
}

import Converter._


/* The object to complete */ 
class ConcreteValidator extends TransValidator{
    
  var bdd : List[tp89.transBddEtat] = List()
  
	// TODO
	def process(m:message){ 
    tp89.traiterMessage(m, bdd)
  }
	
	// TODO
	def getValidTrans: List[((Nat.nat, (Nat.nat, Nat.nat)),Nat.nat)]= {
	  tp89.export(bdd)
	}

	
	def authors= "Houssein"
}


object Product_Type {

def equal_proda[A : HOL.equal, B : HOL.equal](x0: (A, B), x1: (A, B)): Boolean =
  (x0, x1) match {
  case ((x1, x2), (y1, y2)) => HOL.eq[A](x1, y1) && HOL.eq[B](x2, y2)
}

implicit def equal_prod[A : HOL.equal, B : HOL.equal]: HOL.equal[(A, B)] = new
  HOL.equal[(A, B)] {
  val `HOL.equal` = (a: (A, B), b: (A, B)) => equal_proda[A, B](a, b)
}

def equal_bool(p: Boolean, pa: Boolean): Boolean = (p, pa) match {
  case (p, true) => p
  case (p, false) => ! p
  case (true, p) => p
  case (false, p) => ! p
}

} /* object Product_Type */

object tp89 {

import /*implicits*/ Product_Type.equal_prod, Nat.equal_nat

abstract sealed class message
final case class Pay(a: (Nat.nat, (Nat.nat, Nat.nat)), b: Nat.nat) extends
  message
final case class Ack(a: (Nat.nat, (Nat.nat, Nat.nat)), b: Nat.nat) extends
  message
final case class Cancel(a: (Nat.nat, (Nat.nat, Nat.nat))) extends message

abstract sealed class transBddEtat
final case class EnCours(a: ((Nat.nat, (Nat.nat, Nat.nat)), (message, Nat.nat)))
  extends transBddEtat
final case class TransactionAnnuler(a: (Nat.nat, (Nat.nat, Nat.nat))) extends
  transBddEtat
final case class TransactionValider(a: ((Nat.nat, (Nat.nat, Nat.nat)), Nat.nat))
  extends transBddEtat

def equal(ident: Nat.nat, x1: transBddEtat): Boolean = (ident, x1) match {
  case (ident, EnCours(((c, (m, ident1)), (mess, am)))) =>
    (if (Nat.equal_nata(ident, ident1)) true else false)
  case (ident, TransactionAnnuler((c, (m, ident1)))) =>
    (if (Nat.equal_nata(ident, ident1)) true else false)
  case (ident, TransactionValider(((c, (m, ident1)), am))) =>
    (if (Nat.equal_nata(ident, ident1)) true else false)
}

def export(x0: List[transBddEtat]):
      List[((Nat.nat, (Nat.nat, Nat.nat)), Nat.nat)]
  =
  x0 match {
  case Nil => Nil
  case EnCours((t, (m, am))) :: xs => export(xs)
  case TransactionAnnuler(t) :: xs => export(xs)
  case TransactionValider((t, am)) :: xs => (t, am) :: export(xs)
}

def equal_message(x0: message, x1: message): Boolean = (x0, x1) match {
  case (Ack(proda, nat), Cancel(prod)) => false
  case (Cancel(proda), Ack(prod, nat)) => false
  case (Pay(proda, nat), Cancel(prod)) => false
  case (Cancel(proda), Pay(prod, nat)) => false
  case (Pay(proda, nata), Ack(prod, nat)) => false
  case (Ack(proda, nata), Pay(prod, nat)) => false
  case (Cancel(proda), Cancel(prod)) =>
    Product_Type.equal_proda[Nat.nat, (Nat.nat, Nat.nat)](proda, prod)
  case (Ack(proda, nata), Ack(prod, nat)) =>
    Product_Type.equal_proda[Nat.nat, (Nat.nat, Nat.nat)](proda, prod) &&
      Nat.equal_nata(nata, nat)
  case (Pay(proda, nata), Pay(prod, nat)) =>
    Product_Type.equal_proda[Nat.nat, (Nat.nat, Nat.nat)](proda, prod) &&
      Nat.equal_nata(nata, nat)
}

def traiterMessageAux(x0: message, x1: transBddEtat): transBddEtat = (x0, x1)
  match {
  case (Pay(t, am), EnCours((t1, (mess, am1)))) =>
    (if (equal_message(mess, Pay(t1, am1)) && Nat.less_nat(am1, am))
      EnCours((t, (mess, am)))
      else (if (equal_message(mess, Ack(t1, am1)) && Nat.less_eq_nat(am1, am))
             TransactionValider((t, am))
             else (if (equal_message(mess, Cancel(t1))) TransactionAnnuler(t)
                    else EnCours((t, (mess, am))))))
  case (Pay(t, am), TransactionAnnuler(t1)) => TransactionAnnuler(t1)
  case (Pay(t, am), TransactionValider((t1, am1))) =>
    TransactionValider((t1, am1))
  case (Ack(t, am), EnCours((t1, (mess, am1)))) =>
    (if (equal_message(mess, Ack(t1, am1)) && Nat.less_nat(am1, am))
      EnCours((t, (mess, am)))
      else (if (equal_message(mess, Pay(t1, am1)) && Nat.less_eq_nat(am1, am))
             TransactionValider((t, am))
             else (if (equal_message(mess, Cancel(t1))) TransactionAnnuler(t)
                    else EnCours((t, (mess, am))))))
  case (Ack(t, am), TransactionAnnuler(t1)) => TransactionAnnuler(t1)
  case (Ack(t, am), TransactionValider((t1, am1))) =>
    TransactionValider((t1, am1))
  case (Cancel(t), TransactionAnnuler(t1)) => TransactionAnnuler(t)
  case (Cancel(t), TransactionValider((t1, am1))) => TransactionAnnuler(t)
  case (Cancel(t), EnCours((t1, (mess, am1)))) => TransactionAnnuler(t)
}

def traiterMessage(x0: message, x1: List[transBddEtat]): List[transBddEtat] =
  (x0, x1) match {
  case (Cancel(t), Nil) => List(TransactionAnnuler(t))
  case (Pay(t, am), Nil) => List(EnCours((t, (Pay(t, am), am))))
  case (Ack(t, am), Nil) => List(EnCours((t, (Ack(t, am), am))))
  case (Pay((c, (m, ident)), am), x :: xs) =>
    (if (Product_Type.equal_bool(equal(ident, x), true))
      traiterMessageAux(Pay((c, (m, ident)), am), x) :: xs
      else traiterMessage(Pay((c, (m, ident)), am), xs))
  case (Ack((c, (m, ident)), am), x :: xs) =>
    (if (Product_Type.equal_bool(equal(ident, x), true))
      traiterMessageAux(Ack((c, (m, ident)), am), x) :: xs
      else traiterMessage(Ack((c, (m, ident)), am), xs))
  case (Cancel((c, (m, ident))), x :: xs) =>
    (if (Product_Type.equal_bool(equal(ident, x), true))
      traiterMessageAux(Cancel((c, (m, ident))), x) :: xs
      else traiterMessage(Cancel((c, (m, ident))), xs))
}

} /* object tp89 */
