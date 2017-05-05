//5.3.4.1 Tree

sealed trait Tree[A] {
  def fold[B](fnode: (B,B) => B, fleaf: A => B): B =
    this match {
      case Node(lf,rt) => fnode(lf.fold(fnode,fleaf),rt.fold(fnode,fleaf))
      case Leaf(vl) => fleaf(vl)
    }
}
final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

val treeInt: Tree[Int] =
  Node(Node(Leaf(1), Leaf(2)),
    Node(Node(Leaf(3), Leaf(4)),
      Node(Leaf(1), Node(Leaf(2), Leaf(3)))))

treeInt.fold[Int](_ + _ , i => i)
//treeInt.fold[Int]((a,b) => Node(a,b) , i => Leaf(2*i))

val treeSt: Tree[String] =
  Node(Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

treeSt.fold[String]((a,b) => a + " " + b, str => str)