// 4.6.3.2 The Forest of Trees

sealed trait Tree
final case class Node (left:Tree, right:Tree) extends  Tree
final case class Leaf(element:Int) extends Tree

val example = Node(Node(Leaf(1), Leaf(2)),Leaf(3))

object TreeOps {
  def sum(tr:Tree):Int =
    tr match {
      case Node(lf,rt) => sum(lf) + sum(rt)
      case Leaf(el) => el
    }
  def double(tr:Tree):Tree =
    tr match {
      case Node(lf,rt) => Node(double(lf), double(rt))
      case Leaf(el) => Leaf(2 * el)
    }

}

TreeOps.sum(example)
TreeOps.double(example)

