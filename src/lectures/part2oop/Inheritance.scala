package lectures.part2oop

object Inheritance extends App {

  class Animal {
    val creatureType: String = "wild"
    protected def eat() = println("Nom Nom Nom")
  }

  class Cat extends Animal {

    def crunch = {
      eat
      println("Crunch Crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(personName: String, age: Int, idCard: String) extends Person(personName) {

  }

  //Overriding

  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat = println("crunch crunch")
  }

  val dog = new Dog("K9")
  dog.eat

  // type substitution

  val unknownAnimal: Animal = new Dog("K9")

  // super



}
