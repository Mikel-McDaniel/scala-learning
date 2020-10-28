package lectures.part2oop

object AbstractDataTypes extends App {
  //abstract

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("Crunch crunch")
  }

  //traits

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"

    override def eat: Unit = "nomnomnom"

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog()
  val crocodile = new Crocodile()

  crocodile.eat(dog)

  //traits vs abstract class
  //1. Traits can't have constructor parameters
  //2. you can only extend one class but you can have multiple traits
  //3. traits are behavior but abstract class is a type of thing

}
