
//4.1.4.1 Cats, and More Cats

trait Feline {
  def colour: String
  def sound:String
}

case class Lion (colour: String, maneSize:Int) extends Feline {
  val sound = "roar"
}

case class Tiger(colour:String) extends Feline {
  val sound = "roar"
}

case class Panther(colour:String) extends Feline {
  val sound = "roar"
}

case class Cat(colour: String, food: String) extends Feline {
  val sound = "meow"
}


//4.1.4.2 Shaping Up With Traits

trait Shape {
  def sides: Int
  def perimeter:Double
  def area: Double
}

case class Circle (radius: Double) extends Shape {
  def sides = 1
  def perimeter = 2 * math.Pi * radius
  def area = math.Pi * math.pow(radius,2)
}

case class Rectangle ( width: Double, height: Double) extends Shape  {
  def sides = 4
  def perimeter = 2 * width + 2 * height
  def area = width * height
}

case class Square ( size: Double) extends Shape {
  def sides = 4
  def perimeter = 4* size
  def area = size * size
}

//4.1.4.3 Shaping Up 2 (Da Streets)

trait Rectangular extends Shape {
  def width:Double
  def height:Double
  def sides =4
  val perimeter = 2 * width + 2 * height
  def area = width * height
}

case class Square2 ( size:Double) extends Rectangular{
  val width = size
  val height = size
}

case class Rectangle2 ( width:Double,  height: Double) extends Rectangular