
//5.1.3.1 Generic List


sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]


sealed trait LinkedList[A] {
  def length:Int =
    this match {
      case End() => 0
      case Pair(hd,tl) => 1 + tl.length
    }
  def contains(el:A):Boolean =
    this match {
      case End() => false
      case Pair(hd,tl) => hd match {
        case `el` => true
        case _ => tl.contains(el)
      }
    }
  def apply(ind:Int):Result[A] =
    this match {
      case End() => Failure("Index out of bounds")
      case Pair(hd,tl) =>
        if (ind == 0)  Success(hd)
        else tl(ind-1)
    }
}
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]


//5.1.3.2 Working With Generic Types
val example = Pair(1, Pair(2, Pair(3, End())))

assert(example.length == 3)
assert(example.tail.length == 2)
assert(End().length == 0)




assert(example.contains(3) == true)
assert(example.contains(4) == false)
assert(End().contains(0) == false)
// This should not compile
// example.contains("not an Int")



assert(example(0) == Success(1))
assert(example(1) == Success(2))
assert(example(2) == Success(3))
assert(example(3) == Failure("Index out of bounds"))