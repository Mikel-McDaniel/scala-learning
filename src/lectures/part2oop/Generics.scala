package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. List[Cat] extends List[Animal] - COVARIANCE

  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  //animalList.add(new Dog) ???
  //2. No... INVARIANT LIST

  class InvariantList[A]
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] TODO: This does not work

  //3. Hell, no... CONTRAVARIANCE

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)


}
