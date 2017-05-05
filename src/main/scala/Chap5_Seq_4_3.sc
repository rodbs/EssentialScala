
//5.4.4.1 Exercise: Maybe that Was a Mistake (Generic Op􀦞onal Values)


sealed trait Maybe[A]
final case class Full[A](value:A) extends  Maybe[A]
final case class Empty[A]() extends  Maybe[A]

val perhaps1: Maybe[Int] = Empty[Int]
// perhaps: Maybe[Int] = Empty()
val perhaps2: Maybe[Int] = Full(1)
// perhaps: Maybe[Int] = Full(1)
