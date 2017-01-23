package cm5

http://cerig.pagora.grenoble-inp.fr/tutoriel/bases-de-donnees/sommaire.htm
object Main {
	// 1) Basics -----------------------------------------------------------------------
    // Base types and type inference
    1:Int	
    1        // here, the type is automatically inferred
    
    'a'
    "toto"
    ():Unit
    
    // All types (including) base types are objects (contrary to Java)
    1 + 2      // For instance, this is equivalent to the usual method call:
    1.+(2)
 
    // Exercise 1
    
    1 max 4
    // val and var
    val x:Int=1
    x+1            // reassignement to a val is forbidden!
   
    var y=2        // reassignement to a var is possible
    y=3
    y
    
    // If expressions
    
    // Exercise 2
    
    if (1==2) 1 else 2
    if (1==2) 1 else "toto"
    if (1==1) 1
    if (1==1) println(1)
      
    // match-case expressions
    
    val rep= "au revoir"
      
    rep match {
      case "bonjour" => "hello"
      case "au revoir" => "goodbye"
      case _ => "Don't know"
    }
    
    // for
    
    (1).to(10)
    (1).to(10,2)
    
    // Exercice 3
    
    val sb=Set(1,2,3,4,5)
    
    for (i <- sb) println(i*i) 
        
        // Exercice 4
    
    for (i <- (1 to 10)){
      for (j <- 1 to 10) print(i*j+" ")
      println
    }
    // Arrays
    
    val t:Array[String]= new Array[String](3)
    
    // Using the type inference it is less verbose
    val t1= new Array[String](5)
    t1(0)="zero"
    t1(1)="un"
    t1(2)="deux"
    t1(3)="trois"
    t1(4)="quatre"
      
    // Using type inference and simplified constructor it is far less verbose!
    val t2= Array("zero","un","deux","trois","quatre")
    
    // Arrays can be modified
    t2(4)="quatro"
    t2
    
    
    // (Immutable) lists
    
    val l= List(1,2,3,4,5)
    val l1= 0::l
    val l2= l1:+6
    
    val l3= List(7,8,9,10)
    val l4= l2++l3
    l4.reverse             // parameterless method can be called without ()
    l4                     // lists are immutable
    val l5=l4.reverse
    l5
    
    l5 match {
      case Nil => 0
      case e::_ => e
    }

    val lbiz= List(1,2,"tyoto")
    // (Immutable) sets
    val s1=Set(1,2,3,4,5)
    s1.contains(4)
    s1 contains 10    // with the '.' free notation
    
    
    // (Immutable) Tuples
    
    val tu= (1,"toto",18.3)
    tu._1
    tu._2
    
    tu match {case (2,"toto",_) => "found!"
    		  case (_,x,_) => x}
    
    // Maps
    
    val m= Map('C' -> "Carbon",'H' -> "Hydrogen")
    val m1= m+('O' -> "Oxygen")
    m1('C')
    m1('K')
    
    try m1('K') catch{ 
        case _:NoSuchElementException => "Unknown"
    }
    
    // Exercise 5
    
    for(i <- m1){
      println(i._1)
    }

    for((k,v) <- m1){
      println(k)
    }
    
    //2) Functions -----------------------------------------------------------------------
    
    // Basic functions
    
    def plus(x:Int,y:Int)={
      println("Sum of "+x+" and "+y+" is equal to  "+(x+y))
      x+y	    // No return keyword
    }
    
    plus(18,24)
    
    
    // Recursive functions
    
    
    def fact(n:Int):Int=              // result type annotation is compulsory for recursive functions
      if (n<=1) 1 else n*fact(n-1)
    
    fact(10)
    
    
    def gcd(a:Int, b: Int): Int=      // result type annotation is compulsory for recursive functions
      if (b==0) a else gcd(b, a%b)
      
    gcd(15,9)
    
    
    
    // Exercise 6
    
    var num = Map[String, String]()
  
    def addName(name:String, tel:String):Unit={
        num = num+(name->tel)
      }
    
    def getTel(name:String)={
      num(name)
    }
    
    def userList={
      var users = List[String]()
      for((user, num)<-num){
        users = user::users
      }
      users
    }
    
    // Higher order, anonymous functions
    
    // Anonymous functions
    
    ((x: Int) => x+1)       // would be written (lambda x. x+1) in Isabelle/HOL
    ((x: Int) => x+1) (1)   // anonymous functions application
    
    val la=List(1,2,3)
    la.map  ((x: Int) => x+1)
    
    // Exercise 8
    val s="robert"
    s.capitalize
    
    userList
    
    def capUserList=userList.map(x => x.capitalize) 
        
    // Partial application the '_' permits to speak about the function associated to any name/object.
      
    plus(_,_)
    plus(1,_:Int)
    la.map (plus(_:Int,1)) 
    
    
    (_:String).size    // the function associated to the size operation of the String class
    
    (_:Int) + (_:Int)  // the addition function for integer, etc.
    
    (_:String) == "toto"  //the function testing if a string is equal to "toto"
      
 
    // Exercise 9
    
    def capUserList2=userList.map(_.capitalize)
    // Exercise 10
      
    List(1,2,3,4).filter(_>2)
    
    // 3) Object model --------------------------------------------------------------------------------
      
    // Class definition and constructors
    
    class Rational(n:Int, d:Int){          // This also defines the primary constructor
      val num=n
      val den=d
      def isNull:Boolean= (num==0)
      override def toString=num+"/"+den
      def +(x:Rational)={
        new Rational(x.num * this.den + this.num * x.den, this.den * x.den)
      }
      // l'inversion d'un rationnel. unary_- permet d'appeler "- r" pour un rationnel r
      def unary_- ={
        new Rational(-this.num,this.den)
      }
    }
    
    val r= new Rational(5,2)
    println(r)
    println(r.num)
    val r2= new Rational(2,6)
    r + r2
    r
    r.den=10    //forbidden reassignement to val

    // Exercice 11,12,13,14... in the code of Rational
    
    implicit def bool2int(b:Boolean):Int= if (b) 1 else 0
    1 + true
    
    
    // Traits and inheritance
    
    trait IntQueue{
      def get:Int
      def put(x:Int)
    }
    
    
    class MyIntQueue extends IntQueue{
      protected var b= List[Int]()
      def get={
        val h=b(0) 
        b=b.drop(1) 
        h}
      
      def put(x:Int)={
        b=b:+x
      }
    }
    
    val iq:IntQueue= new MyIntQueue
    iq.put(1)
    iq.put(2)
    iq.put(3)
    iq.get
    
    // inheritance
    class SafeIntQueue extends MyIntQueue {  
      override def get={if (b.nonEmpty) super.get else 0}
    }
    
    object InfiniteQueueOfOne extends IntQueue{
      def get=1
      def put(x:Int)={}
    }

    InfiniteQueueOfOne.get
    InfiniteQueueOfOne.get
    InfiniteQueueOfOne.get
    InfiniteQueueOfOne.put(18)
    InfiniteQueueOfOne.get
    InfiniteQueueOfOne.get
    
    
    
    //polymorphism
    
    trait Queue[T]{
      def get:T
      def push(x:T)
    }
    
    class MyQueue[T] extends Queue[T]{
      protected var b= List[T]()
      def get={
        val h=b(0)
        b=b.drop(1)
        h
      }
    
      def put(x:T)={
        b=b:+x
      }
    }
      
    
    // case classes
    
    sealed trait Expression
    case class BinExpr(o:String,l:Expression,r:Expression) extends Expression
    case class Constant(r:Rational) extends Expression
    case class Inv(e:Expression) extends Expression
    
    val e=  BinExpr("+",Constant(new Rational(18,27)), Inv(Constant(new Rational(1,2))))   // No need for 'new' to build objects from case classes!
    
    // pattern matching
    
    def op(e:Expression):String={
      e match {
        case BinExpr(o,_,_) => o
        case _ => "No operator"
      }
    }
    
    op(e)
    
    // Exercise 15

    def eval(e:Expression):Rational={
      e match {
        case Constant(r) => r
        case Inv(e) => - eval(e)
        case BinExpr("+",l,r) => eval(l) + eval(r)
      }
    }
    // interoperability between Java and Scala
    
    import scala.collection.JavaConverters._
    
    val lj:java.util.List[Int]= new java.util.ArrayList[Int]()
    lj.add(1)
    lj.add(2)
    lj.add(3)
    
    val sb1= lj.asScala.toList
    val sl1= sb1.asJava
    

    
}
    