// 4.6.3.2 The Forest of Trees
//polymorphism

sealed trait Tree {
  def sum:Int
  def double:Tree
}
final case class Node (left:Tree, right:Tree) extends  Tree {
  def sum:Int =
    left.sum + right.sum
  def double:Tree =
    Node(left.double, right.double)
}
final case class Leaf(element:Int) extends Tree {
  def sum:Int =
    element
  def double:Tree =
    Leaf(2*element)
}

val example = Node(Node(Leaf(1), Leaf(2)),Leaf(3))
example.sum
example.double

