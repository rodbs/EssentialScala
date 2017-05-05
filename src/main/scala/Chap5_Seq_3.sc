
//5.2.3.1 A Be􀂂er Abstrac􀦞on

sealed trait IntList {
  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end,f))
    }
  def length:Int =
    fold[Int](0, (_,tl) => 1 + tl)
  def product:Int =
    fold[Int](1, (hd,tl) => hd * tl)
  def sum:Int =
    fold[Int](0, (hd,tl) => hd + tl)
  def double:IntList =
    fold[IntList](End,(hd,tl) => Pair(2*hd, tl))
}

final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList


val example = Pair(1, Pair(2, Pair(3, End)))

assert(example.length == 3)
assert(example.tail.length == 2)
assert(End.length == 0)

example.double
