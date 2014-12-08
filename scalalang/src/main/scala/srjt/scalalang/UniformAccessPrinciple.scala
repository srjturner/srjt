package srjt.scalalang

object UAP extends App {

  // function expecting a no-arg function that return a String
  def expectFunction(x: =>String) = println("1:" + x) 
  
  // function expecting a String value
  def expectValue(x:String) = println("2:" + x)
  
  // no-arg function that return a String
  def stringFunction(): String = "function"
  
  // String value 
  val stringValue = "value"
  
  expectFunction(stringFunction); 
  expectFunction(stringValue); 
  expectValue(stringFunction)
  expectValue(stringValue)
  
  val l = List(1,2,3)
  //l foldRight()
}