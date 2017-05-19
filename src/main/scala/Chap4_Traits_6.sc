//4.6.3.1 A List of Methods




sealed trait IntList
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

val example = Pair(1, Pair(2, Pair(3, End)))
assert(sum(example) == 6)
assert(sum(example.tail) == 5)
assert(sum(End) == 0)

def sum(list: IntList): Int =
  list match {
    case End => 0
    case Pair(hd, tl) => hd + sum(tl)
  }



