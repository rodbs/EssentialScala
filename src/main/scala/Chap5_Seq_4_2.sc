

//5.4.3.1 Exercise: Generic Sum Type


sealed trait Sum[A,B]
final case class Left[A,B](value:A) extends Sum[A,B]
final case class Right[A,B](value:B) extends Sum[A,B]

Left[Int, String](1).value
// res: Int = 1
Right[Int, String]("foo").value
// res: String = foo

val sum: Sum[Int, String] = Right("foo")
// sum: Sum[Int,String] = Right(foo)

sum match {
  case Left(x) => x.toString
  case Right(x) => x
}
// res: String = foo

def intOrString(input: Boolean): Sum[Int, String] =
  if(input == true) {
    Left[Int, String](123)
  } else {
    Right[Int, String]("abc")
  }