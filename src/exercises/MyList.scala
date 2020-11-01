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

  def filter(predicate: A => Boolean): MyList[A]
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def ++[B >: A](list: MyList[B]): MyList[B] //Concat
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](int: B): MyList[B] = Cons(int, Empty)

  override def printElements: String = ""

  override def filter(predicate: Nothing => Boolean): Empty.type = Empty

  override def map[B](transformer: Nothing => B): Empty.type = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): Empty.type = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](int: B): MyList[B] = Cons(int, this)

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, tail ++ list)

  override def printElements: String =
    if(tail.isEmpty) h.toString
    else h + " " + t.printElements

  override def filter(predicate: A => Boolean): MyList[A] =
    if(predicate.apply(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def map[B](transformer: A => B): MyList[B] = Cons(transformer.apply(h), tail.map(transformer))

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = transformer(h) ++ tail.flatMap(transformer)


}



object ListTest extends App {
  var cons: MyList[Int] = Empty

  var list = cons.add(1).add(2).add(3).map(n => n * 2)
  println(list.toString)
}