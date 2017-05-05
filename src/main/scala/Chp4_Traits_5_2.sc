
//4.5.6.2 Calculation


sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation


object Calculator {
  def +(calc:Calculation, x:Int):Calculation = calc match {
    case Success(result) => Success(result + x)
    case Failure(reason) => Failure(reason)
  }
  def -(calc:Calculation, x:Int):Calculation = calc match {
    case Success(result) => Success(result - x)
    case Failure(reason) => Failure(reason)
  }
  def /(calc:Calculation, x:Int):Calculation = calc match {
    case Success(result) => x match {
      case 0 => Failure("Division by zero")
      case _ => Success(result/x)
    }
    case Failure(reason) => Failure(reason)
  }
}

Calculator.+(Success(1),3)
Calculator.-(Success(1),3)
Calculator./(Success(1),0)


