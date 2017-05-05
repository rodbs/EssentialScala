
//5.5.4.3 Sequencing Computa􀦞ons


val list = List(1, 2, 3)

list.flatMap(a => List(a,-a))




sealed trait Maybe[A] {
  def flatMap[B](fn: A => Maybe[B]): Maybe[B] =
    this match {
      case Full(v) => fn(v)
      case Empty() => Empty[B]()
    }
  def map[B](fn: A => B):Maybe[B] =
    flatMap[B](v => Full(fn(v)))

}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]

val list2 = List(Full(3), Full(2), Full(1))

list2.map( maybe => maybe flatMap { x => if(x%2 == 0) Full(x) else Empty })

//list2.map(maybe => maybe flatMap { x => if(x % 2 == 0) Full(x) else Empty })

