package lectures.part2oop

object Notations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the hell!?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")//Infix notation or Operator notation - can only be used on methods with a single parameter (syntactic sugar)

  //Operators in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))
  println(1.+(2))
  //ALL OPERATORS ARE METHODS
  //Akka actors have ! ?

  //prefix notation

  val x = -1
  val y = 1.unary_-

  //unary_ prefix only works with a few operators (- + ~ !)
  println(!mary)

  //Postfix notations
  //println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) //is the same as above
}
