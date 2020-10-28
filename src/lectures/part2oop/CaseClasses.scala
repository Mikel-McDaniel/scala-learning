package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  /*
  1. class parameters are fields
  2. sensible toString implementation
  3. Equals and hashcode implemented out of the box
  4. Case classes have handy copy methods
  5. Case classes have companion objects
  6. Case classes are serializable
  7. Case classes have extractor patterns - can be used in pattern matching
   */

  case object UnitedKingdom {
    def name: String = "The UK for BK and NI"
  }
}
