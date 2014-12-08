package srjt.scalalang.case_classes_pattern_match

import scala.collection.mutable.Map;

object ExprTest extends App {

  
  /**
   * Instance of Expr that means "((x*z)-(9/y))" 
   */
  val exp: Expr = Minus(Mult(Var("x"),Var("z")),Div(Const(9),Var("y")))
  
  /**
   * Instance of Environment (i.e. our alias for the function String => Double 
   * - see package object) which returns 5 for "x", 3 for "y" and 0 for anything else.
   */
  val env: Environment = {case "x" => 5 case "y" => 3 case _ => 0}
 
  /**
   * What if our source data is a Map, rather than an Environment? We can use
   * Map.apply as the Environment, see below...
   */
  val envMap = Map[String, Double]("x" -> 5, "y" -> 3, "z" -> 0);
  
  /**
   * Evaluate the Environment using the pattern-matching defined in
   * the eval() method below.
   */
  println("Case Evaluation with x=5, y=3: " + eval(exp, env))
  
  /**
   * Evaluate the Environment using the eval methods of the Expr  
   * classes rather than pattern-matching (feels more "OO" to me).
   */
  println("Evaluation with x=5, y=3: " + exp.eval(env))
  
  /**
   * Evaluate the Map passing Map.apply as our Environment (String => Double) 
   * Note Map.get returns the value wrapped in an Option, but Map.apply does not.
   * Note also - we are passing the apply function of *that particular Map* - in
   * other words, it's effectively a closure.
   */
  println("Evaluation with Map.apply as the Environment: " + eval(exp, envMap.apply))
  
  /**
   * Evaluate the Map again, but using currying - note the two args lists of
   * curryMapLookup() - to convert a Map lookup to an Environment (String => Double).
   * Note also: any un-named method call is interpreted as a call to an apply()
   * function, so m(s) is a call to MapLike.apply.
   */
  def curryMapLookup(m : Map[String, Double]) (s: String) : Double = m(s);
  println("Evaluation of Map with currying: " + eval(exp, curryMapLookup(envMap)))

  val s = Sum(Const(1),Const(2))
  val lhs = s.l
  
  /**
   * Pattern-matching example. This is how you are supposed to use case 
   * classes, decomposing their tree-like structure in a match expression.
   * 
   * Note: "case" expressions can be used with *any* type, not just case classes.
   * 
   * Note2: by matching the pattern like Sum(l, r) we have access to the constructor
   * arguments of that case class, which we don't directly have if we refer to the
   * Expr t directly.
   */
  def eval(t: Expr, env: Environment): Double = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Minus(l, r) => eval(l, env) - eval(r, env)
    case Mult(l, r) => eval(l, env) * eval(r, env)
    case Div(l, r) => eval(l, env) / eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }
  
}