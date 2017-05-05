
//6.8.4.1 Union of Sets

val st1 = Set(1,2,3)
val st2 = Set(2,3,4)

def unionSet[A](set1: Set[A], set2: Set[A]): Set[A] = {
  set1.foldLeft(set2)( (set, elt)  => (set + elt))
}
unionSet(st1,st2)


val mp1 = Map("a" -> 1, "b" -> 1)
val mp2 = Map("a" -> 2, "c" -> 2)

def unionMap[A](map1: Map[A, Int], map2: Map[A, Int]): Map[A, Int] = {
  map1.foldLeft(map2){ (map, elt) =>
    val (k,v) = elt
    val newV = map.getOrElse(k,v)
    map + (k -> newV)
  }
}
unionMap(mp1, mp2)

