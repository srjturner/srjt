package srjt.scalalang.structural_typing

object DiTestApp extends App {

  val dao = new DaoImpl()
  val service = new ServiceImpl(dao)
  val client = new Client(this)
  client.callService
  
}