
//4.6.3.1 A List of Methods


sealed trait IntList {
  def length: Int =
    this match {
      case End => 0
      case Pair(hd, tl) => 1 + tl.length
    }
  def product: Int =
    this match {
      case End => 1
      case Pair(hd,tl) => hd * tl.product
    }
  def double: IntList =
    this match {
      case End => End
      case Pair(hd,tl) => Pair(2*hd, tl.double)
    }
}

final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList


val example = Pair(1, Pair(2, Pair(3, End)))

assert(example.length == 3)
assert(example.tail.length == 2)
assert(End.length == 0)

assert(example.product == 6)
assert(example.tail.product == 6)
assert(End.product == 1)

assert(example.double == Pair(2, Pair(4, Pair(6, End))))
assert(example.tail.double == Pair(4, Pair(6, End)))
assert(End.double == End)

