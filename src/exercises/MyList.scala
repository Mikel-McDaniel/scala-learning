package exercises

abstract class MyList[+A] {
  //Head = first element of the list
  //Tail = remainder of the list
  //isEmpty = is this list empty
  //add - takes integer and returns a new list with this element added
  //toString - returns a string representation

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](int: B): MyList[B] = new Cons(int, Empty)

  override protected def printElements: String = ""
}

class Cons[+A](val h: A, val t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](int: B): MyList[B] = new Cons(int, this)

  override protected def printElements: String =
    if(tail.isEmpty) h.toString
    else h + " " + t.printElements
}

trait MyPredicate[T] {
  def test(param: T): Boolean
}

trait MyTransformer[A, B] {
  def transform(param: A): B
}