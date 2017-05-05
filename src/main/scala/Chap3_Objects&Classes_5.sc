
//3.5.3.1 Feed the Cats

case class Cat (name:String, colour:String, food:String)

val oswald =  Cat("Oswald","Black", "Milk")
val henderson =  Cat("Hederson","Ginger", "Chips")
val quentin =  Cat("Quentin", "Tabby and white", "Curry")

object ChipShop {
  def willServe(ct:Cat) = {
    ct match {
      case Cat(_,_,"Chips") => true
      case _ => false
    }
  }
}

ChipShop.willServe(oswald)
ChipShop.willServe(henderson)


//3.5.3.2 Get Off My Lawn!

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

object Dad {
  def rate (fm:Film) = {
    fm match{
      case Film(_,_,_,Director("Clint", "Eastwood",_)) => 10.0
      case Film(_,_,_,Director("John", "McTiernan",_)) => 7.0
      case _ => 3.0
    }
  }
}