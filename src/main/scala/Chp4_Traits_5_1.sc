
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
sealed trait TrafficLight {
  def next : TrafficLight =  this match {
    case Red => Green
    case Green => Yellow
    case Yellow => Red
   }
}

final case object Red extends TrafficLight
final case object Green extends TrafficLight
final case object Yellow extends TrafficLight




