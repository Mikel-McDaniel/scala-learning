package lectures.part3FunctionalProgramming

object WhatsAFunction extends App {

  //Use functions as first class elements

  /*
  1. make a function that takes 2 strings and concats
  2. go to MyList and modify the MyTransformer and MyPredicate into function types
  3. define a function that takes an int and returns another function that takes an int and returns another int
   */

  def concat(str1: String, str2: String): String = str1 + str2


  //THIS IS CALLED A CURRIED FUNCTION
  val specialFunction: (Int) => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(int1: Int) = new Function1[Int, Int] {
      override def apply(int2: Int): Int = int1 + int2
    }
  }
}
