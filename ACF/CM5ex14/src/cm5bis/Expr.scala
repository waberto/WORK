package cm5bis

sealed trait Expression
case class BinExpr(o:String,l:Expression,r:Expression) extends Expression
case class Constant(r:Rational) extends Expression
case class Inv(e:Expression) extends Expression