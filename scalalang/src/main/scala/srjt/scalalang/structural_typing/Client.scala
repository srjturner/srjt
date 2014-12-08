package srjt.scalalang.structural_typing

/**
 * This declares its constructor to require something based on "structural typing"
 * (aka duck typing)  - i.e. anything that has a "service" val that implements
 * the Service trait. This is NOT really DI, it's more service locator..
 */
class Client(env : {val service: Service}) {

  def callService = env.service.doBusiness
  
}