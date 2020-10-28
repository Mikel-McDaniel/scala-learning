package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 //IF expression
  println(aConditionValue)

  var i = 0
  while(i < 10) { //DO NOT USE WHILE LOOPS IN SCALA
    println(i)
    i += 1
  }
  //EVERYTHING IN SCALA IS AN EXPRESSION
  var aVariable = 2
  val aWeirdValue = (aVariable = 3)  //UNIT === void

  println(aWeirdValue)

  //Side effects: println(), while, reassignments

  //code blocks

  val aCodeBlock = {
    val y = 2
    val z = y+1
    if (z > 2) "hello" else "goodbye"
  }
}
