//4.2.2.3 A Short Division Exercise

sealed trait DivisionResult
final case class Finite(value:Int) extends DivisionResult
final case object Infinite extends DivisionResult

object divide {
  def apply(num:Int, den:Int):DivisionResult ={
    if (den==0) Infinite else Finite(num/den)
  }
}

divide(1,2)
divide(1,0)

divide(4,2) match {
  case Finite(value) => s"It's finite: $value"
  case Infinite => s"It's infinite"
}