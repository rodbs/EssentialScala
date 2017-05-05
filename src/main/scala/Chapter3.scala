/**
  * Created by user on 4/28/2017.
  */
object Chapter3 extends App {
  class Cat (val name:String, val colour:String, val food:String)

  println("Ex3.1.6.1: Cats Again")
  val oswald = new Cat("Oswald","Black", "Milk")
  val henderson = new Cat("Hederson","Ginger", "Chips")
  val quentin = new Cat("Quentin", "Tabby and white", "Curry")

  println("Ex3.1.6.2: Cats on the Prowl")
  object ChipShop {
    def willServe(ct:Cat) ={
      if (ct.food == "Chips") true
      else false
    }
  }




  println("Ex3.1.6.3 : Directorial")

  class Director (val firstName:String, val lastName:String, val yearOfBirth:Int) {

    def name = s"$firstName $lastName"

    def copy(
              firstName: String = this.firstName,
              lastName: String = this.lastName,
              yearOfBirth: Int = this.yearOfBirth): Director =
      new Director(firstName, lastName, yearOfBirth)
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

  println(assert(eastwood.yearOfBirth  == 1930))// should be 1930
  println(assert(dieHard.director.name ==  "John McTiernan"))// should be "John McTiernan"
  println(assert(invictus.isDirectedBy(nolan) == false))// should be false


  highPlainsDrifter.copy(name = "L'homme des hautes plaines")
  // returns Film("L'homme des hautes plaines", 1973, 7.7, /* etc */)
  thomasCrownAffair.copy(yearOfRelease = 1968,
    director = new Director("Norman", "Jewison", 1926))
  // returns Film("The Thomas Crown Affair", 1926, /* etc */)
  inception.copy().copy().copy()
  // returns a new copy of `inception`


  println("Ex3.1.6.4 : A simpler counter")

  class Counter(val count:Int) {
    def dec = new Counter(count-1)
    def inc = new Counter(count+1)
  }

  new Counter(10).inc.dec.inc.inc.count

  println("Ex3.1.6.5 : Counting fast")

  println("Ex3.1.6.4 : Additional counting")


}