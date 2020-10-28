package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahah")
  }

/*
1. Generic trait MyPredicate[-T]
2. Generic trait MyTransformer[-A, B] - converts an A to a B
3. MyList:
   - map(MyTransformer) => MyList
   - filter(MyPredicate) => MyList
   - flatmap(Transformer from A to MyList[B])
 */


}
