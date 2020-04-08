package controllers

import play.api.mvc._
import scala.util.Random

class Application extends InjectedController {

  def index = Action {
    Ok((Random.nextInt(5) + 3).toString)
  }

}
