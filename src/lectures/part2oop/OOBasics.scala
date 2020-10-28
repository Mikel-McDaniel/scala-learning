package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
}

class Person(name: String, val age: Int) {
  //body

  def this(name: String) = this(name, 0) //Overloaded constructor
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }
}

//Class parameters are NOT FIELDS