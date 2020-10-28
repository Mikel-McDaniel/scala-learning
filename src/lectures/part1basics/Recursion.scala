package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {


  def factorial(n : Int): Int = {
    if(n <= 1) 1
    else n * factorial(n - 1)
  }

  def anotherFactorial(n: Int): BigInt = { //TAIL RECURSION - Use the recursive call as the LAST expression
    @tailrec
    def factorialHelper(x: Int, accumulator: Int): BigInt = {
      if(x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }
    factorialHelper(n, 1)
  }


  //TODO: Assignments down here-----
  @tailrec
  def concatenateTailrec(str: String, n: Int, accumulator: String): String = {
    if(n <= 0) accumulator
    else concatenateTailrec(str, n - 1, str + accumulator)
  }

  def fibonacci(n: Int): Int = {
    @tailrec
    def adder(x: Int, last: Int, nextToLast: Int): Int = {
      if(x >= n) last
      else adder(x + 1, last + nextToLast, last)
    }
    if(n <= 2) 1
    else adder(n, 1, 1)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }

}
