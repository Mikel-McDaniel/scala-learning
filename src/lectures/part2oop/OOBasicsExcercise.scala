package lectures.part2oop

object OOBasicsExcercise extends App {
  val counter = new Counter
  counter.inc(5).print

}

class Writer(val firstName: String, val surname: String, val year: Int) {
  def fullName(): String = s"$firstName $surname"
}

class Novel(val name: String, val releaseYear: Int, val author: Writer) {
  def authorAge(): String = s"${releaseYear - author.year}"

  def isWrittenByAuthor(author: Writer): Boolean = author.fullName().equals(this.author.fullName())

  def copy(newYear: Int): Novel = {
    new Novel(this.name, newYear, this.author)
  }
}

class Counter(count: Int = 0) {
  def currentCount(): Int = count


  def inc() = {
    println("incrementing")
    new Counter(count + 1)
  }

  def dec() = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter =
    if(n <= 0) this
    else inc.inc(n - 1)

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n - 1)
  }

  def print(): Unit = println(currentCount)

}
