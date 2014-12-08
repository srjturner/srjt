package srjt.scalalang.type_alias_parameterisation

// ******* Type Parameterisation ******* 

/**
 * Abstract base entity using type-parameterisation to allow the
 * type of the id variable to be defined by subclasses
 */
abstract class AbstractEntityParameterised[ID_TYPE] {
  var id : ID_TYPE 
}
class CustomerEntity(override var id : Int) extends AbstractEntityParameterised[Int] {}

// ******* Abstract Types ******* 

/**
 * Alternative to above: Abstract base entity using an abstract type 
 * definition to allow the type of the id variable to be defined by subclasses
 */
abstract class AbstractEntityTypeAliased {
  type ID_TYPE
  var id : ID_TYPE
}
class VehicleEntity(override var id : String) extends AbstractEntityTypeAliased {
  type ID_TYPE = String
}

// ******* Types Aliasing ******* 

/**
 * Type declaration to make code more readable by describing another 
 * type in terms of its role in the specific class (in this case clarifying Dates)
 */
class PersonEntity(override var id : Int) extends AbstractEntityTypeAliased {
  type ID_TYPE = Int
  type Timestamp = java.util.Date; // Redefine Date to describe its intended role
  type DateStamp = java.util.Date; // And again, for day-only Dates.
  var created : Timestamp = _ // must be explicitly initialised to null (= _)
  var birthday : DateStamp = _ // ditto
}

object EntityApp extends App {
  
  val c = new CustomerEntity(1)
  val v = new VehicleEntity("abc")
  val p = new PersonEntity(2)
  println("CustomerEntity id = " + c.id)
  println("VehicleEntity id = " + v.id)
  println("PersonEntity created = " + p.created)
  
}