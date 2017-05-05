
//5.2.3.1 A Be􀂂er Abstrac􀦞on

sealed trait IntList {
  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end,f))
    }
  def length:Int =
    fold(0, (_,tl) => 1 + tl)
  def product:Int =
    fold(1, (hd,tl) => hd * tl)
  def sum:Int =
    fold(0, (hd,tl) => hd + tl)


}
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList