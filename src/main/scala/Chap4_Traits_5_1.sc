
//4.5.6.1 Traffic Lights

//polymorphism
sealed trait TrafficLight {
  def next: TrafficLight
}
final case object Red extends TrafficLight {
  def next: TrafficLight =
    Green
}
final case object Green extends TrafficLight {
  def next: TrafficLight =
    Yellow
}
final case object Yellow extends TrafficLight {
  def next: TrafficLight =
    Red
}

//pattern matching
sealed trait TrafficLight2 {
  def next : TrafficLight2 =  this match {
    case Red2 => Green2
    case Green2 => Yellow2
    case Yellow2 => Red2
   }
}

final case object Red2 extends TrafficLight2
final case object Green2 extends TrafficLight2
final case object Yellow2 extends TrafficLight2




