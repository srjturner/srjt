package srjt.scalalang.variance

abstract class Animal {
  val name : String
  def speak : String
}

class Cat(val name : String) extends Animal {
  def speak : String = "miaow" 
}

class Dog(val name : String) extends Animal {
  def speak : String = "woof" 
}

abstract class Person {
  val name : String
}

class Spinster(val name : String) extends Person {}

class Chav(val name : String) extends Person {}