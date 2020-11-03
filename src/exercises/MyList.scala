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

  //hofs
  def forEach(f: A => Unit): Unit
  def sort(compareTo: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C]
  def fold[B](start: B)(f: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](int: B): MyList[B] = Cons(int, Empty)

  override def printElements: String = ""

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def map[B](transformer: Nothing => B): MyList[Nothing] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def forEach(f: Nothing => Unit): Unit = ()

  override def sort(compareTo: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], f: (Nothing, B) => C): MyList[C] = {
    if(!list.isEmpty) throw new RuntimeException("Lists must be the same length")
    else Empty
  }

  override def fold[B](start: B)(f: (B, Nothing) => B): B = start

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

  //HOFs
  override def forEach(f: A => Unit): Unit = {
    f(head)
    tail.forEach(f)
  }

  override def sort(compareTo: (A, A) => Int): MyList[A] = {

    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if(compareTo(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = tail.sort(compareTo)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C] = {
    if(list.isEmpty) throw new RuntimeException("Lists must be the same length")
    else new Cons(f(head, list.head), tail.zipWith(list.tail, f))
  }

  override def fold[B](start: B)(f: (B, A) => B): B = tail.fold(f(start, head))(f)
}



object ListTest extends App {
  var cons: MyList[Int] = Empty

  var list = cons.add(1).add(2).add(3).add(5).add(20).add(53).add(22)
  var compareTo = (x: Int, y: Int) => {if(x > y) 1 else -1}
  list = list.sort(compareTo)
  list.forEach((x: Int) => println(x))
}