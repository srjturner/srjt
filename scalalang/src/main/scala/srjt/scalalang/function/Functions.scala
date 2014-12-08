package srjt.scalalang.function

object Functions extends App {
  
  // Call by Name / Call by Value
   
  /** 
   * This is known as "call by name" but it is easier to think of it
   * as "pass by name" or better yet, think of " => Int" as meaning 
   * an anonymous function that takes no args and returns an Int. 
   * The effect is that this anonymous function is evaluated each time
   * it is referenced in the function body, rather than being evaluated 
   * before it is passed to the function ("call/pass by value"). Note:
   * of course each arg may be "by name" or "by value". 
   */
  def f(x: => Int) : Int = x * x
  def a() : Int = {println("evaluating a()"); 2}
  println(f(a))
  
  // Currying
  
  /**
   * This is a function that takes two other functions as input 
   * and returns another function which combines (composes) them.
   * In other words, its a curried function.
   */
  def compose(g:Int=>Int, h:Int=>Int) = (x:Int) => g(h(x))
  val minusOneTimesTwo = compose({_*2}, {_-1})
  for (i <- 1 to 5) {
    println(i + " minusOneTimesTwo = " + minusOneTimesTwo(i))
  }
  
//  val zScoreFunctionSyntax = (mean:Double, sd:Double) => (x:Double) => (x-mean)/sd
//  val zScoreForMyMeanAndSdFunction = zScoreFunctionSyntax(7, 0.4)
//  println(zScoreForMyMeanAndSdFunction)
//  println(zScoreForMyMeanAndSdExplicit(2))
  
  /**
   * Currying syntax variation 1: Explicit
   */
   // Note: ZScore (aka standard score) is the number of standard deviations
   // a sample is above the mean.
  def zScoreExplicitSyntax(mean:Double, sd:Double) = (x:Double) => (x-mean)/sd
  val zScoreForMyMeanAndSdExplicit = zScoreExplicitSyntax(7, 0.4)
  println(zScoreForMyMeanAndSdExplicit(2))
  
  /**
   * Currying syntax variation 2: Syntactic Sugar
   * 
   * Because of the syntactic sugar, when we declare the partially-applied 
   * function, we must now put a wildcard _ to represent the missing arguments list..
   */
  def zScoreSugarSyntax(mean:Double, sd:Double)(x:Double) = (x-mean)/sd
  val zScoreForMyMeanAndSdSugar = zScoreSugarSyntax(7, 0.4)_
  println(zScoreForMyMeanAndSdSugar(2))
  
  /** 
   * You can also pass the second argument list in curly brackets
   * allowing you to make control structures that feel like native language.
   */
  val zScoreForMyMeanAndSdSugar2 = zScoreSugarSyntax(6, 0.3) {
    2
  }
  println(zScoreForMyMeanAndSdSugar2)
  
  
}