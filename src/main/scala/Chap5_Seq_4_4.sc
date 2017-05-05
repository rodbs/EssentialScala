

//5.4.6.2 Folding Maybe

sealed trait Maybe[A] {
  def fold[B]( f_full: A => B, f_empty:B ):B =
    this match {
      case Full(v) => f_full(v)
      case Empty() => f_empty
    }
}
final case class Full[A](value: A) extends Maybe[A]
final case class Empty[A]() extends Maybe[A]


//5.4.6.3 Folding Sum
sealed trait Sum[A, B] {
  def fold[C](f_left: A => C, f_right: B=> C ):C =
    this match {
      case Left(a) =>  f_left(a)
      case Right(b) => f_right(b)
    }
}

final case class Left[A, B](value: A) extends Sum[A, B]
final case class Right[A, B](value: B) extends Sum[A, B]

