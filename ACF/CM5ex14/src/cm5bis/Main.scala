package cm5bis

object Main extends App {
  def eval(e:Expression):Rational={
      e match {
        case Constant(r) => r
        case Inv(e1) => 0 - eval(e1)
        case BinExpr("+",e1,e2) => eval(e1) + eval(e2)
        case BinExpr("-",e1,e2) => eval(e1) - eval(e2)
      }
    }
  
   // we define an implicit conversion from Int to Rational
    implicit def intToRat(i:Int):Rational={new Rational(i)}
    
	val e=  BinExpr("+",Constant(new Rational(18,27)), Inv(Constant(new Rational(1,2)))) 
	println(e)
	println("eval e="+eval(e))
}