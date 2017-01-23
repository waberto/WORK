package cm5bis

class Rational(n:Int,d:Int){
      require(d!=0)   // On ne peut construire un rationnel que si d est différent de 0
      private def gcd(a:Int, b: Int): Int=            // function private to the class
      if (b==0) a else gcd(b, a%b)
      
      override def toString = num + "/" + den
      val num=n / gcd(n,d)                           // les rationnels sont simplifiés automatiquement à la création
      val den=d / gcd(n,d)
      def this(n:Int){this(n,1)}
      
      def + (that:Rational)={
        new Rational(num * that.den + that.num * den,den*that.den)
      }
      
      def * (that:Rational)={
        new Rational(num * that.num,den * that.den)
      }
      
      def -(r:Rational):Rational={
        new Rational((r.num*this.den)-(r.den*this.num), (r.den*this.den))
      }
      
      // l'inversion d'un rationnel. unary_- permet d'écrire "- r" pour inverser un rationnel r
      def unary_- ={
        new Rational(-this.num,this.den)
      }
}
    
