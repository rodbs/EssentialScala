
//5.5.4.1 Mapping Lists

sealed trait LinkedList[A] {
  def map[B](fn: A => B): LinkedList[B] =
    this match {
      case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
      case End() => End[B]()
    }
}
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]



val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))

list.map(_ * 2)
list.map(_ + 1)
list.map(_ / 3)


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




