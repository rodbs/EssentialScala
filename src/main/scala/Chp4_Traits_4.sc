
//4.4.4.1 Stop on a Dime

sealed trait TrafficLight
final case object Red extends TrafficLight
final case object Green extends TrafficLight
final case object Yellow extends TrafficLight


//4.4.4.2 Calculator
sealed trait Calculation
final case class Success(result:Int) extends  Calculation
final case class Failure(reason:String) extends  Calculation


//4.4.4.3 Water, Water, Everywhere

sealed trait Source
final case object Well extends Source
final case object Spring extends Source
final case object Tap extends Source

final case class BottledWater(size:Int,  source: Source, carbonated: Boolean)
