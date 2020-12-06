package controllers
import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}
import services.ProviderService
import scala.concurrent.ExecutionContext.Implicits.global


class ProviderController @Inject() (val controllerComponents: ControllerComponents, val providerService: ProviderService)
  extends BaseController {

  def fetch_specificProvider(searchString: String) = Action.async { implicit request =>
    val result = scala.concurrent.Future{providerService.fetch_Provider(searchString)}
    result.map { i => Ok(Json.toJson(i))}
  }

}
