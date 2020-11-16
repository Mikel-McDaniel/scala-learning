package lectures.part3FunctionalProgramming

import scala.util.Random

object Sequences extends App {

	//Seq is a trait(interface) for all sequences

	val aSequence = Seq(1, 2, 3, 4)

	println(aSequence)
	println(aSequence.reverse)
	println(aSequence(2))
	println((aSequence ++ Seq(3, 6, 12, 11)).sorted)

	//LIST ARRAY and VECTOR are all sequences

	//ranges
	val aRange: Seq[Int] = 1.until(10);
	println(aRange)
	aRange.foreach(println)

	(1 until 5).foreach(println)

	//lists
	val aList = List(1, 2, 3)
	val prepend = 42 +: aList :+ 22
	println(prepend)

	val fiveApples = List.fill(5)(Math.random())
	println(fiveApples)
	println(prepend.mkString("start", "||", "end"))

	//Array
	val numbers = Array(1, 2, 3)
	val threeNum = Array.ofDim[String](3)
	threeNum.foreach(println)

	val numberSequence: Seq[Int] = numbers; //Implicit conversion

	println(numberSequence)

	//vectors
	val vector: Vector[Int] = Vector(1, 2, 3, 4)

	val MAX_RUNS = 1000
	val MAX_CAPACITY = 1000000
	def getWriteTime(collection: Seq[Int]): Double = {
		val r = Random
		val times = for {
			it <- 1 to MAX_RUNS
		} yield {
			val currentTime = System.nanoTime()
			collection.updated(r.nextInt(MAX_CAPACITY), r.nextInt())
			System.nanoTime() - currentTime
		}

		times.sum * 1.0 / MAX_RUNS
	}

	val theList = (1 to MAX_CAPACITY).toList
	val theVector = (1 to MAX_CAPACITY).toVector

	val listTime = getWriteTime(theList)
	val vectorTime = getWriteTime(theVector)

	//println(listTime)
	println(vectorTime)

}
