import scala.util.Random

object Main extends App {


  def fib1( n : Int) : Int = n match {
     case 0 | 1 => n
     case _ => fib1( n-1 ) + fib1( n-2 )
     return n
  }


  def fib2( n : Int ) : Int = {
  var a = 0
  var b = 1
  var i = 0
  val n: Int = Random.nextInt(10)

  while( i < n ) {
    var c = a + b
    a = b
    b = c
    i = i + 1
  }
  return b
}


  def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
  }
println(matchTest(2))  // other
println(matchTest(1))   // one


  println(fib1(5))
  println(fib2(6))
}
