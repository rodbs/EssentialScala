
//6.2.7.2 Do-It-Yourself


val s1 = Seq(1,1,2,3,4)


//minimum
def minimun(sq:Seq[Int]) =
 sq.foldLeft(Int.MaxValue)((a,b) => math.min(a,b))

minimun(s1)


//Unique
def insert(seq: Seq[Int], elt:Int): Seq[Int] = {
  if(seq.contains(elt)) seq
  else elt +: seq
}

def unique(seq:Seq[Int]) =
  seq.foldLeft(Seq.empty[Int])(insert _)
  // IMPORTANT PATTERN
unique(s1)


//Revere
def reverse(seq:Seq[Int]) =
 seq.foldLeft(Seq.empty[Int])((seq,elt) => elt +: seq)

reverse(s1)


//map

//foldLeft




