package controllers
import javax.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}
import services.ProviderCostService
import scala.concurrent.ExecutionContext.Implicits.global


class ProviderCostController @Inject() (val controllerComponents: ControllerComponents, val providerCostService: ProviderCostService)
  extends BaseController {

  def fetch_specificProviderCosts(searchString: String) = Action.async { implicit request =>
    val specificProviderCosts = scala.concurrent.Future{providerCostService.fetch_ProviderCosts(searchString)}
    specificProviderCosts.map { specificProviderCost => Ok(Json.toJson(specificProviderCost))}
  }

}
