package controllers

import play.api._
import play.api.mvc._
import scala.util.Random

object Application extends Controller {

  def index = Action {
    Ok((Random.nextInt(5) + 3).toString)
  }

}