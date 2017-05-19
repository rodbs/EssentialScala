
//4.2.2.2 The Color and the Shape
sealed trait Color {
  def red: Double
  def green: Double
  def blue: Double

  def isLight =(red+green+blue)/ 3.0 > 5.0
  def isDark = !isLight
}

final case object Red extends Color{
  val red =1.0
  val green = 0.0
  val blue = 0.0
}
final case object Yellow extends Color{
  val red = 1.0
  val green = 1.0
  val blue = 0.0
}
final case object Blue extends Color{
  val red = 0.0
  val green = 0.0
  val blue = 1.0
}

final case class CustomColor (red:Double, green: Double, blue:Double) extends Color



sealed trait Shape {
  def sides: Int
  def perimeter:Double
  def area: Double
  def color: Color
}

final case class Circle (radius: Double, color: Color) extends Shape {
  def sides = 1
  def perimeter = 2 * math.Pi * radius
  def area = math.Pi * math.pow(radius,2)
}

sealed trait Rectangular extends Shape {
  def width:Double
  def height:Double
  def sides =4
  val perimeter = 2 * width + 2 * height
}

final case class Square ( size:Double, color:Color) extends Rectangular{
  val width = size
  val height = size
  def area = size * size
  //def perimeter = 4 * size
}

final case class Rectangle ( width:Double,  height: Double, color:Color) extends Rectangular{
  def area = width * height
  //def perimeter = 2 * width * height
}

object Draw {
  def apply(shape: Shape): String = shape match {
    case Circle(radius, color) =>
      s"A ${Draw(color)} circle of radius ${radius}cm"
    case Square(size, color) =>
      s"A ${Draw(color)} square of size ${size}cm"
    case Rectangle(width, height, color) =>
      s"A ${Draw(color)} rectangle of width ${width}cm and height ${height}cm"
  }

  def apply(cl:Color) = cl match {
    case Red => "red"
    case Yellow => "yellow"
    case Blue => "blue"
    case cl => if (cl.isLight) "light" else "dark"
  }
}

Draw(Circle(10, Red))
Draw(Rectangle(3, 4, CustomColor(0.4, 0.4, 0.6)))

