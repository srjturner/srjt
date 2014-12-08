package srjt.scalalang.implicits

object Implicits extends App {

  implicit def strToJsonSimpleType(s : String) : JsonSimpleType = {
    new JsonSimpleType(s)
  }
  
  implicit def strToJsonComplexType(s : String) : JsonComplexType = {
    new JsonComplexType(s)
  }
 
  abstract class Json[T] {
    var value : T
    var parent : Json[_] = _
    def depth : Int = {
      parent match {
        case j : Json[_] => parent.depth + 1
        case _ => 0
      }
    }
    def indent = "".padTo(depth * 2, " ").mkString("")
  }
  
  class JsonSimpleType (name : String) extends Json[String] {
    var value : String = _
    def ->(v : String) = {
      value = v
      this
    }
    override def toString() = {
      var sb = new StringBuilder
      sb ++= indent ++= "\"" ++= name ++= "\" : \"" ++= value ++= "\""
      sb.toString
    } 
  }
  
  class JsonComplexType(name : String) extends Json[Seq[Json[_]]] {
    var value : Seq[Json[_]] = _
    def ->(v : Json[_]*) = { // have to use varargs, not Seq, to match an arbitrary number of  
      value = v              // args in a Json literal (see j1 defintion below)
      value.foreach(x => x.parent = this)
      this
    }
    override def toString() = {
      var sb = new StringBuilder
      sb ++= indent ++= "\"" ++= name ++= "\" : {\n"
      sb ++= value.mkString(", \n")
      sb ++= "\n" ++= indent ++= "}"
      sb.toString
    } 
  }
  
  /**
   * Despite both Json subclasses defining the -> method, the correct
   * conversion is picked based on the parameter type. When the param is a String,
   * the compiler looks for a conversion to a class which implements ->(String)
   * but when the param is one or more Json instances, it looks for a conversion 
   * to a class that implements ->(Json*)
   */
  val j1 = "person"->("name"->"Simon Turner", "address"->("street"->"Nicolas Road", "city"->"Manchester"))
  println(j1)
  
}