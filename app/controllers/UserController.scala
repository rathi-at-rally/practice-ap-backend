package controllers

import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}
import services.UserService
import scala.concurrent.ExecutionContext.Implicits.global

class UserController @Inject() (val controllerComponents: ControllerComponents, val userService: UserService)
  extends BaseController {

  def validate_credentials(qid: String, qemail: String, qpassword: String) = Action.async { implicit request =>
    val result = scala.concurrent.Future{userService.validate(qid, qemail, qpassword)}
    result.map { i => Ok(Json.toJson(i))}
  }

}
