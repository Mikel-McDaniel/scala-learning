package lectures.part3FunctionalProgramming

object TuplesAndMaps extends App {

	//Tuples - Finate ordered "Lists"
	var tuple: Tuple2[Int, String] = new Tuple2(2, "Hello Scala")
	//Same as
	var aTuple: (Int, String) = new Tuple2(2, "Hello Scala")

	println(aTuple._1) //can also use ._2 (This is 1 based rather than 0 based)
	println(aTuple.copy(_2 = "Goodbye Java"))
	println(aTuple.swap)

	//Maps key => value (just like in java)
	var map: Map[String, Int] = Map()
	var phoneBook: Map[String, Int] = Map(("James", 555), "Moe" -> 123).withDefaultValue(-1) //withDefaultValue will return this value if key doesn't exist.  Use to protect against NoSuchElementException

	//Map operations
	println(phoneBook.contains("Moe"))//returns a boolean if the key exists
	println(phoneBook("James")) //the apply method returns the value of the key

	//How to put in a map
	val newEntry:(String, Int) = "Schmoe" -> 678
	val updatedPhonebook = phoneBook + newEntry
	println(updatedPhonebook)

	//Map/Flatmap/Filter on maps
	println(updatedPhonebook.map(pair => pair._1.toLowerCase() -> pair._2))
	println(updatedPhonebook.filter(tuple => tuple._1.endsWith("oe")))

	val names = List("Mary", "Moe", "James", "Johnson", "Jimminy", "Zebrax")

	println(names.groupBy(name => name.charAt(0)))

	//Assignment
	/*
	1. If I have a map with entries "Jim" and "JIM" and I call a map function to upper case it, what would happen?
	2. Make an overly simplified social network with maps
		a. Person will have a name (String)
		b. Network will keep a map of each name and a list of friends (Map(String -> List(String))
		c. Add a person
		d. Remove a person
		e. friend
		f. unfriend
		g. number of friends of a given person
		h. person with the most friends
		i. people with no friends
		j. if there is a social connection between 2 people (Direct or not)
	 */
	object Network {
		def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
			if (network.keySet.contains(person)) throw new Exception("This person already exists")
			else  network + (person -> Set[String]())

		def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
			if(network.keySet.contains(person)) network.filter(touple => !touple._1.equals(person))
			else throw new Exception("No such person exists")

		def friend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
			if(network.keySet.contains(person1) && network.keySet.contains(person2)) {
				val stepOne: (String, Set[String]) = network.filter(touple => touple._1.equals(person1)).map(touple => (touple._1, touple._2 + person2)).toList(0)
				val stepTwo: (String, Set[String]) = network.filter(touple => touple._1.equals(person2)).map(touple => (touple._1, touple._2 + person1)).toList(0)
				network + stepOne + stepTwo
			}
			else throw new Exception("One or more of the \"Friends\" doesn't exist")
		}

		def unfriend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
			if(network.keySet.contains(person1) && network.keySet.contains(person2)) {
				val stepOne: (String, Set[String]) = network.filter(touple => touple._1.equals(person1)).map(touple => (touple._1, touple._2 - person2)).toList(0)
				val stepTwo: (String, Set[String]) = network.filter(touple => touple._1.equals(person2)).map(touple => (touple._1, touple._2 - person1)).toList(0)
				network + stepOne + stepTwo
			}
			else throw new Exception("")
		}

		def friendCount(network: Map[String, Set[String]], person: String): Int = {
			if(network.keySet.contains(person)) {
				network(person).size
			}
			else throw new Exception("Person does not exist")
		}

		def mostFriends(network: Map[String, Set[String]]): Set[String] = {
			val map: Map[Int, Map[String, Set[String]]] = network.groupBy(tuple => tuple._2.size);
			val maximum = map.keySet.max
			map(maximum).keySet
		}

	}

	var network: Map[String, Set[String]] = Map[String, Set[String]]();
	network = Network.add(network, "Joey")
	network = Network.add(network, "Moe")
	network = Network.add(network, "Schmoe")
	network = Network.friend(network, "Joey", "Moe")
	network = Network.friend(network, "Joey", "Schmoe")
	println(network)
	println(Network.friendCount(network, "Joey"))
	network = Network.friend(network, "Joey", "Moe")
	println(Network.friendCount(network, "Joey"))
	println(Network.mostFriends(network))





}
