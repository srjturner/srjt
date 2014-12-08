package srjt.scalalang.infinitelooping

import scala.collection.immutable._
import scala.collection.immutable.Stream.ConsWrapper

// http://derekwyatt.org/2011/07/29/understanding-scala-streams-through-fibonacci.html
object Streamer extends App {
  
  /**
   * Note: #:: is a right-associative (because ending in :) function of 
   * Stream which is an alias for a function that takes a head (a value)
   * and a tail (a function that produces a Stream) and produces a Stream.
   */
  def from(n: Int): Stream[Int] = {
    println("Requesting n = " + n)
    n #:: from(n + 1)
  }
 
  val nats = from(1)
  println(nats(5))

  /**
   * Since #:: is right-associative (see above), we are NOT relying on implicit conversions
   * here, we are calling a method on a Stream (the right-hand arg in each case)
   */
  val fibs : Stream[BigInt] = 0 #:: 1 #:: (fibs zip fibs.tail).map{ case (a,b) => a+b }
  fibs take 20 foreach println

}