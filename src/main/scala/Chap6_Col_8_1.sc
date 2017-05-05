//6.8.3.1 Favorites


val people = Set(
  "Alice",
  "Bob",
  "Charlie",
  "Derek",
  "Edith",
  "Fred")
val ages = Map(
  "Alice" -> 20,
  "Bob" -> 30,
  "Charlie" -> 50,
  "Derek" -> 40,
  "Edith" -> 10,
  "Fred" -> 60)
val favoriteColors = Map(
  "Bob" -> "green",
  "Derek" -> "magenta",
  "Fred" -> "yellow")
val favoriteLolcats = Map(
  "Alice" -> "Long Cat",
  "Charlie" -> "Ceiling Cat",
  "Edith" -> "Cloud Cat")



def favoriteColor (person:String ) =
  favoriteColors.get(person)

def favoriteColor2 (person:String ) =
  favoriteColors.get(person).getOrElse("beige")

favoriteColor("Alice")
favoriteColor2("Alice")



def printColors =
  for { p <- people
  } println(s"${p}'s favorite color is ${favoriteColor(p)}!")

def printColors2 = people foreach { person =>
  println(s"${person}'s favorite color is ${favoriteColor(person)}!")
}

printColors



def lookup[A](name:String, mp:Map[String,A]) =
  mp.get(name)

lookup("Bob", favoriteColors)



//oldest: TODO
val oldest: