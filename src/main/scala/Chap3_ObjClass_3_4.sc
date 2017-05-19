
//3.4.5.1 Case Cats
case class Cat (name:String, colour:String, food:String)

val oswald =  Cat("Oswald","Black", "Milk")
val henderson =  Cat("Hederson","Ginger", "Chips")
val quentin =  Cat("Quentin", "Tabby and white", "Curry")

oswald


//3.4.5.2 Roger Ebert Said it Best…
case class Director (firstName:String, lastName:String, yearOfBirth:Int) {

  def name = s"$firstName $lastName"
}

object Director {

  def older(dt1:Director, dt2:Director):Director ={
    if (dt1.yearOfBirth < dt2.yearOfBirth ) dt1 else dt2
  }
}


case class Film ( name:String,  yearOfRelease:Int,  imbdRating:Double,  director:Director) {

  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy(dt:Director) = dt == director
}

object Film {

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


//3.4.5.3 Case Class Counter
class Adder(amount: Int) {
  def add(in: Int) = in + amount
}
case class Counter4(count: Int = 0) {
  def dec: Counter4 = dec()
  def inc: Counter4 = inc()
  def dec(amount: Int = 1): Counter4 = new Counter4(count - amount)
  def inc(amount: Int = 1): Counter4 = new Counter4(count + amount)
  def adjust(adder:Adder):Counter4 = new Counter4(adder.add(count))
}
new Counter4(10).inc.inc(10).count
Counter4(0)
Counter4().inc
Counter4().inc.count



//3.4.5.4 Application, Application, Application

case class Person(first: String, last: String) {
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

Person("Bob","Pat")
Person("Peter Garcia")


