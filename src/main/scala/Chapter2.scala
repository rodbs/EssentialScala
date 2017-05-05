/**
  * Created by user on 4/27/2017.
  */
object Chapter2 extends App {
  object Oswald {
    val colour = "Black"
    val food = "Milk"
  }
}

object Henderson {
  val colour: String = "Ginger"
  val food: String = "Chips"
}

object Quentin {
  val colour: String = "Tabby and white"
  val food: String = "Curry"
}

object calc{
  def square (x:Double) = math.sqrt(x)
  def cube(x:Double) = x * square(x)
}


object calc2{
  def square (x:Double) = math.sqrt(x)
  def cube(x:Double) = x * square(x)

  def square (x:Int) = math.sqrt(x)
  def cube(x:Int) = x * square(x)



}


