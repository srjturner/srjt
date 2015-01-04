package srjt.scalalang

object Temp {
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (matches, rest) = xs.span(x1 => x1 == x)
      matches :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  def encode[T](xs: List[T]): List[(T, Int)] = {
    val packed = pack(xs)
    packed.map(x: T => (x.head, x.length))
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
  
  val chars = List("a","a","a","b","b","c","c","c","c")
                                                  //> chars  : List[String] = List(a, a, a, b, b, c, c, c, c)
  pack(chars)                                     //> res0: List[List[String]] = List(List(a, a, a), List(b, b), List(c, c, c, c))
                                                  //| 
  encode(chars)                                   //> res1: List[(String, Int)] = List((a,3), (b,2), (c,4))
  
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((t1,u1) => f(t1) :: u1)
                                                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  mapFun(chars, (x: String) => x.hashCode)        //> res2: List[Int] = List(97, 97, 97, 98, 98, 99, 99, 99, 99)
  
}