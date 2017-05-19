class Counter(val count:Int) {
  def dec = new Counter(count-1)
  def inc = new Counter(count+1)
}

new Counter(10).inc.dec.inc.inc.count



class Counter2(val count:Int) {
  def dec(amount:Int = 1) = new Counter2(count - amount)
  def inc(amount:Int = 1) = new Counter2(count + amount)
}
new Counter2(10).inc().count  //needs parenthesis



//method overloading to recreate the original parenthesis-free methods
class Counter3(val count: Int) {
  def dec: Counter3 = dec()
  def inc: Counter3 = inc()
  def dec(amount: Int = 1): Counter3 = new Counter3(count - amount)
  def inc(amount: Int = 1): Counter3 = new Counter3(count + amount)
}
new Counter3(10).inc.inc(10).count


//with Adder
class Adder(amount: Int) {
  def add(in: Int) = in + amount
}
class Counter4(val count: Int) {
  def dec: Counter4 = dec()
  def inc: Counter4 = inc()
  def dec(amount: Int = 1): Counter4 = new Counter4(count - amount)
  def inc(amount: Int = 1): Counter4 = new Counter4(count + amount)
  def adjust(adder:Adder):Counter4 = new Counter4(adder.add(count))
}
new Counter4(10).inc.inc(10).count



