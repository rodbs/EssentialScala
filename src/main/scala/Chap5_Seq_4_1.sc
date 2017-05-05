
//5.4.1.1 Exercise: Pairs (Generic Product Types)

class Pair[A,B]()(one:A, two:B)

val pair = Pair("hi", 2)
pair._1
pair._2



Tuple2("hi", 1) // unsugared syntax
// res: (String, Int) = (hi,1)
("hi", 1) // sugared syntax
// res: (String, Int) = (hi,1)
("hi", 1, true)
// res: (String, Int, Boolean) = (hi,1,true)


def tuplized[A, B](in: (A, B)) = in._1
// tuplized: [A, B](in: (A, B))A
tuplized(("a", 1))
// res: String = a


(1, "a") match {
  case (a, b) => a + b
}
// res: String = 1a