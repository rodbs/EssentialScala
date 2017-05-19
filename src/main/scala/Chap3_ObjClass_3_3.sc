
class Person(first: String, last: String) {
  val firstName = first
  val lastName = last
  def name = firstName + " " + lastName
}

object Person {
  def apply(name: String):Person = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}

Person.apply("John Doe").firstName
Person("Jonh Doe").firstName





class Director (val firstName:String, val lastName:String, val yearOfBirth:Int) {

  def name = s"$firstName $lastName"

  def copy(
            firstName: String = this.firstName,
            lastName: String = this.lastName,
            yearOfBirth: Int = this.yearOfBirth): Director =
    new Director(firstName, lastName, yearOfBirth)
}

object Director {

  def apply( firstName:String,  lastName:String,  yearOfBirth:Int) ={
    new Director(firstName,  lastName,  yearOfBirth)
  }

  def older(dt1:Director, dt2:Director):Director ={
    if (dt1.yearOfBirth < dt2.yearOfBirth ) dt1 else dt2
  }
}


class Film (val name:String, val yearOfRelease:Int, val imbdRating:Double, val director:Director) {

  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy(dt:Director) = dt == director

  def copy( name:String = this.name,
            yearOfRelease:Int = this.yearOfRelease,
            imbdRating:Double = this.imbdRating,
            director:Director = this.director) = {
    new Film(name, yearOfRelease,imbdRating, director)
  }

}

object Film {
  def apply(name:String, yearOfRelease:Int,  imbdRating:Double,  director:Director) = {
    new Film(name, yearOfRelease, imbdRating, director)
  }

  def newer(film1: Film, film2: Film): Film =
    if (film1.yearOfRelease < film2.yearOfRelease) film1 else film2

  def highestRating(fm1:Film, fm2:Film) ={
    if (fm1.imbdRating > fm2.imbdRating) fm1.imbdRating
    else fm2.imbdRating
  }

  def oldestDirectorAtTheTime(fm1:Film, fm2:Film) ={
    if(fm1.directorsAge > fm2.directorsAge) fm1.director
    else fm2.director
  }
}

val eastwood = new Director("Clint", "Eastwood", 1930)
val mcTiernan = new Director("John", "McTiernan", 1951)
val nolan = new Director("Christopher", "Nolan", 1970)
val someBody = new Director("Just", "Some Body", 1990)

val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)
val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

//val prestige: Film = bestFilmByChristopherNolan()
//new Film("Last Action Hero", 1993, 8,mcTiernan)
//Film("Last Action Hero", 1993,8, mcTiernan)
//Film.newer(highPlainsDrifter, thomasCrownAffair)
//Film.type
