package srjt.scalalang.case_classes_pattern_match

/**
 * Base class for case-classes representing Expressions.
 */
abstract class Expr {
  def eval(env: Environment): Double;
}

/**
 * Note the following about case classes:
 * 1. You can write Const(5) instead of new Const(5))
 * 2. You can get the value of the constructor parameters as if using getters: c.val.
 * 3. They have default equals and hashCode which work on structure not identity.
 * 4, A default toString which prints the value in a form like how it was declared.
 * 4. instances can be decomposed through pattern matching - see ExprTest.eval().
 */
case class Sum(l: Expr, r: Expr) extends Expr {
  def eval(env: Environment): Double = l.eval(env) + r.eval(env);
}

case class Minus(l: Expr, r: Expr) extends Expr {
  def eval(env: Environment): Double = l.eval(env) - r.eval(env);
}

case class Mult(l: Expr, r: Expr) extends Expr {
  def eval(env: Environment): Double = l.eval(env) * r.eval(env);
}

case class Div(l: Expr, r: Expr) extends Expr {
  def eval(env: Environment): Double = l.eval(env) / r.eval(env);
}

case class Var(n: String) extends Expr {
  def eval(env: Environment): Double = env(n);
}

case class Const(v: Double) extends Expr {
  def eval(env: Environment): Double = v;
}
