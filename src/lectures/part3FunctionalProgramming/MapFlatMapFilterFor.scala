package lectures.part3FunctionalProgramming

object MapFlatMapFilterFor extends App {

	val list = List[Int](1, 2, 3)

	//map
	println(list.map(_ + 1))
	println(list.map(_ + " is numeric"))

	//filter
	println(list.filter(_ % 2 == 0))

	//flatMap
	println(list.flatMap((x: Int) => List(x, 2 * x)))

	/*
	Excercise: create a grid using the 2 below lists
	 */

	val numbers = List[Int](1, 2, 3, 4)
	val letters = List[String]("a", "b", "c", "d")
	val colors = List[String]("Black", "White")

	//This is how iterating is done in functional programming
	val squares = colors.flatMap((color: String) => numbers.flatMap((x: Int) => letters.map((char: String) => char + x + "-" + color)))

	println(squares)

	//compiler matches compiles to the same code as the "squares" function above.  This is a shorthand that is far more readable
	// If guard will be used in place of filter
	val forCombinations = for {
		num <- numbers if (num % 2 == 0)
		char <- letters
		color <- colors
	} yield char + num + "-" + color

	println(forCombinations)
}
