
//4.2.2.1 Prin􀦞ng Shapes

sealed trait Shape {
  def sides: Int
  def perimeter:Double
  def area: Double
}

case class Circle (radius: Double) extends Shape {
  def sides = 1
  def perimeter = 2 * math.Pi * radius
  def area = math.Pi * math.pow(radius,2)
}

trait Rectangular extends Shape {
  def width:Double
  def height:Double
  def sides =4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Square ( size:Double) extends Rectangular{
  val width = size
  val height = size
}

case class Rectangle ( width:Double,  height: Double) extends Rectangular

object Draw {
  def apply(sp:Shape) = sp match {
    case Rectangle(width, height) =>
      s"A rectangle of width ${width}cm and height ${height}cm"
    case Square(size) =>
      s"A square of size ${size}cm"
    case Circle(radius) =>
      s"A circle of radius ${radius}cm"
  }
}

val cr = Circle (4.5)
Draw(cr)

