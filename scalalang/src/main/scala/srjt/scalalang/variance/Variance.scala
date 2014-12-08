package srjt.scalalang.variance

/**
   * Variance: 
   * 
   * A function has contravariant arguments. That is, you can substitute 
   * for function type F any function F' where the arguments are
   * supertypes of the corresponding arguments to F. This is true because
   * when we invoke F' we will simply do so with subtypes of what it 
   * accepts (expects).
   * 
   * A function has a covariant return type. That is, you can substitue
   * for function type F any function F' where the return type is a subtype
   * of the return type of F. This is true because when we invoke F' we will 
   * expect it to return type T, and F' will simply return a subtype of T.
   */
class Variance {
  
  val cats = List(new Cat("snowy"), new Cat("fluffy"))
  
  /**
   * Here is our function type declared: Cat => Person
   */
  def listCatOwners(findOwner : Cat => Person) = {
    for (cat <- cats)
      println("Owner of " + cat.name + " = " + findOwner(cat).name)
  }

}

object VarianceAppTest extends App {
  
  val v = new Variance
  
  /**
   * This function exactly matches the type of findOwner : Cat => Person
   * 
   * Note: I have explicitly indicated the Function type, which is strictly
   * speaking unnecessary, it's just for clarity.
   * 
   * Note 2: Rhe if/else in the function body is strictly speaking
   * an if "expression" and not an if "statement", because it must evaluate 
   * to a value to be valid (we can't omit the "else").
   */
  val matchingArgMatchingReturn : (Cat) => Person = 
    (c : Cat) => {
      if (c.name == "snowy") new Spinster("Betty")
      else new Chav("Gaz")
    }
  v.listCatOwners(matchingArgMatchingReturn)
  
  /**
   * This function has contravariant arguments and a covariant return type
   * with respect to Cat => Person. 
   */
  val contraArgCoReturn : (Animal) => Spinster = 
    (a : Animal) => {
      if (a.name == "snowy") new Spinster("Wendy")
      else new Spinster("Joan")
    }
  
  // ******************
  // Here is the proof!
  // ******************
  // contraArgCoReturn is substitutable for findOwner
  // i.e. (Animal) => Spinster  <i>is a subtype of</i> (Cat) => Person.
  v.listCatOwners(contraArgCoReturn)
  
}