package srjt.scalalang.collections

object Lists extends App {
  
  // Left fold /: take
  // left fold ints, summing them together
  // Note: left fold is curried
  val ints = List(1,2,3)
  def sum(list : List[Int]) = (0 /: list) (_ + _)
  println(sum(ints))
  
  // left fold the strings, reversing their order
  val strings = List("foo", "bar")
  def concat(list : List[String]) = ("" /: list) {
    (a, b) => b + a
  }
  println(concat(strings))
  
  // left fold the strings, splitting each into a List of chars, and concatenating them together
  val splitStrings = (List[Char]() /: strings) {(chars, str) => str.toList ::: chars}
  println(splitStrings)

}