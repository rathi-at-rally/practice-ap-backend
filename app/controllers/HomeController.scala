package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import java.awt.Desktop.Action
import services.UserService
import services.ProviderService
import services.ProviderCostService
import services._
import utilities.Constants
import scala.concurrent._
import ExecutionContext.Implicits.global

@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  def validate_credentials(qid: String, qemail: String, qpassword: String) = Action.async { implicit request =>
    val userService = new UserService()
    val result = scala.concurrent.Future{userService.validate(qid, qemail, qpassword)}
    result.map { i => Ok(Json.toJson(i))}
  }

    def fetch_specificProviderCosts(key: String) = Action.async { implicit request =>
      val providerCostService = new ProviderCostService()
      val result = scala.concurrent.Future{providerCostService.fetch_ProviderCosts(key)}
      result.map { i => Ok(Json.toJson(i))}
  }

   def fetch_specificProvider(searchString: String) = Action.async { implicit request =>
     val providerService = new ProviderService()
     val result = scala.concurrent.Future{providerService.fetch_Provider(searchString)}
     result.map { i => Ok(Json.toJson(i))}
   }
  }

