package srjt.scalalang.structural_typing

trait Dao {

  def getData : String
  
}

class DaoImpl extends Dao {
  
  def getData : String = "data from storage (honest)"
  
}