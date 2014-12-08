package srjt.scalalang.structural_typing

trait Service {

  def doBusiness;
  
}

class ServiceImpl (dao : Dao) extends Service {
  
  def doBusiness = println("I am ServiceImpl doing Business with data : " + dao.getData);
  
}