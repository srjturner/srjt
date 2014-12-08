package srjt.scalalang.types

object HigherTypes {
  
  implicit def strToInt(x: String) = x.toInt

}

/**
 * Container takes any type that can be "viewed as" an Int. Since the implicit cobversion
 * from String to Int is in scope for app (below) we can have a Container[String]
 */
class Container[A <% Int] { 
  
  def addIt(x: A) = 123 + x 
  
}

object app extends App {
 
  import HigherTypes._

  val container = new Container[String]()
  container.addIt("345")
  print(container)
  
}