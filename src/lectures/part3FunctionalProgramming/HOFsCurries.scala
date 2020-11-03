package lectures.part3FunctionalProgramming

object HOFsCurries extends App {

  //val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???

  //function that applies a function n times over a given value x

  def nTimes(function: Int => Int, times: Int, subject: Int): Int = {
    if (times >= 0) subject
    else nTimes(function, times - 1, function(subject))
  }


  def nTimesBetter(f: Int => Int, times: Int): Int => Int =
    if(times <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, times - 1)(f(x))

  val plusOne = (x: Int) => x + 1
  val plus10 = nTimesBetter(plusOne, 10)

  println(plus10(1))

  val superAdder = (x: Int) => (y: Int) => x + y

  println(superAdder(15)(10))

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  curriedFormatter("%1.2f")(Math.PI)

  /*
  1. forEach method A => Unit
     - [1, 2, 3].forEach(x => println(x))
  2. sort method ((A, A) => Int) => MyList[A]
     - [1, 2, 3].sort((x, y) => y - x) => [3, 2, 1]
  3. zipWith method (list, (A, A) => B) => MyList[B]
     - [1, 2, 3].zipWith([4, 5, 6], x * y) => [1 * 4, 2 * 5, 3 * 6]
  4. fold(start)(function)
     - [1, 2, 3].fold(0)(x + y) = 6


  5. In this class:
    - create a toCurry and fromCurry method
        - toCurry         (Int, Int) => Int       TO           Int => Int => Int

    - compose andThen methods
       - compose(f, g)   returns a function that behaves like this x => f(g(x))
       - andThen(f, g)   returns a function that behaves like this x => g(f(x))

   */

  def toCurry(func: (Int, Int) => Int): Int => Int => Int = {
    x => y => func(x, y)
  }

  def fromCurry(func: Int => Int => Int): (Int, Int) => Int = {
    (x, y) => func(x)(y)
  }

}
