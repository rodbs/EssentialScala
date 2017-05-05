
def readInt(str: String): Option[Int] =
  if(str matches "\\d+") Some(str.toInt) else None

readInt("123")
// res: Option[Int] = Some(123)
readInt("abc")
// res: Option[Int] = None

readInt("abc").getOrElse(0)
// res: Int = 0

readInt("123") match {
  case Some(number) => number + 1
  case None => 0
}
// res: Int = 124


def sum(optionA: Option[Int], optionB: Option[Int]): Option[Int] =
  optionA.flatMap(a => optionB.map(b => a + b))
sum(readInt("1"), readInt("2"))
// res: Option[Int] = Some(3)
sum(readInt("1"), readInt("b"))
// res: Option[Int] = None
sum(readInt("a"), readInt("2"))
// res: Option[Int] = None


val optionA = readInt("123")
val optionB = readInt("234")
for {
  a <- optionA
  b <- optionB
} yield a + b


//6.5.1.1 Adding Things

object Calc {
  def addOptions(opt1: Option[Int], opt2: Option[Int]) =
    for {
      a <- opt1
      b <- opt2
    } yield a + b

  def addOptions2(opt1: Option[Int], opt2: Option[Int]) =
    opt1.flatMap(a => opt2.map(b => a + b))


  //6.5.1.2 Adding All of the Things

  def addOptions(opt1: Option[Int], opt2: Option[Int], opt3:Option[Int]) =
    for {
      a <- opt1
      b <- opt2
      c <- opt3
    } yield a + b + c

  def addOptions2(opt1: Option[Int], opt2: Option[Int], opt3:Option[Int]) =
    opt1.flatMap(a => opt2.flatMap(b =>  opt3.map( c => a + b + c)))


  //6.5.1.3 A(nother) Short Division Exercise

  def divide(num:Int, den:Int) =
    if (den==0) None
    else Some(num/den)

  def divideOptions(opt1: Option[Int], opt2: Option[Int]) =
    for {
      a <- opt1
      b <- opt2
      c <- divide(a,b)
    } yield c
}

Calc.divideOptions(Some(6),Some(2))

