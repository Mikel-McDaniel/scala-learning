package lectures.part2oop

object Objects {
  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY (Static)

  object Person {
    //Static/class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }
  class Person(val name: String) {
    //Instance level functionality
  }
  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)
  val mary = new Person("Mary")
  val john = new Person("John")
  val bobby = Person(mary, john)

  // Scala objects are singletons

  //scala applications - scala object with def main(args: Array[String]): Unit

  def main(args: Array[String]): Unit = { //main method, can be used instead of extending App

  }


}
