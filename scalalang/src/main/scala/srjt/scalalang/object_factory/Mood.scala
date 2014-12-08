package srjt.scalalang.object_factory

/**
 * This is an example of a class hierarchy with a companion "object factory".
 * Mood (class) is the base class, with Angry and Happy being concrete 
 * implementations. Mood (object) is the factory for instances of Mood (class).
 * To use (see MoodTestApp) just do "def m = Mood(#)".
 */
abstract class Mood {

  def reply(question : String) : String;
  
}

class Angry extends Mood {
  
  def reply(question : String) : String = "HOW DARE YOU ASK " + question + "?"
  
}

class Happy extends Mood {
  
  def reply(question : String) : String = "I'm glad you asked me " + question
  
}

/**
 * Note how this has to implement apply() but can define any arguments for
 * that method. 
 */
object Mood {
  
  /**
   * Declaring the return type ": Mood" is actually redundant and can be removed
   * because this is implicitly the object factory for Mood instances. 
   */
  def apply(sleepQuantity : Int) : Mood = {
    if (sleepQuantity < 5) new Angry
    else new Happy
  }
  
}