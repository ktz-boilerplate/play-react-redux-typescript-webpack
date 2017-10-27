package controllers

import com.google.inject.Inject
import play.api.mvc._

class Application @Inject() (components: ControllerComponents) extends AbstractController(components) {
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
}
