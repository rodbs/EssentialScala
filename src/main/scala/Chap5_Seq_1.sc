
//5.1.3.1 Generic List

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
  def apply(ind:Int):A =
    this match {
      case End() => throw new Exception("Attempted to get element from an Empty list")
      case Pair(hd,tl) =>
        if (ind == 0)  hd
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



assert(example(0) == 1)
assert(example(1) == 2)
assert(example(2) == 3)
assert(try {
  example(3)
  false
} catch {
  case e: Exception => true
})