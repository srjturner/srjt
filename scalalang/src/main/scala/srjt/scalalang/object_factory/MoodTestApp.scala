package srjt.scalalang.object_factory

object MoodTestApp extends App {

  val angryMood = Mood(sleepQuantity=3) // "sleepQuantity=" is optional
  val happyMood = Mood(sleepQuantity=8) // just added for clarity
  println("Mood with 3 hours sleep = " + angryMood.getClass.getName())
  println("Mood with 8 hours sleep = " + happyMood.getClass.getName())
  
}