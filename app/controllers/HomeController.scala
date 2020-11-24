package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import Models.SearchSpecific
import Models.SearchResult
import Models.ProfileDetails
import java.awt.Desktop.Action

@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  implicit val searchWrites = new Writes[SearchResult] {
    def writes(searchResult: SearchResult) = Json.obj(
      "name" -> searchResult.name,
      "work" -> searchResult.work,
      "address1" -> searchResult.address1,
      "address2" -> searchResult.address2,
      "location" -> searchResult.location,
      "vicinity" -> searchResult.vicinity
    )
  }

  implicit val searchSpecificWrites = new Writes[SearchSpecific] {
    def writes(searchSpecfic: SearchSpecific) = Json.obj(
      "services" -> searchSpecfic.services,
      "costNear" -> searchSpecfic.costNear,
      "estimatedTotalCost" -> searchSpecfic.estimatedTotalCost,
      "insurancePays" -> searchSpecfic.insurancePays,
      "estimatedOutOfPocketCost" -> searchSpecfic.estimatedOutOfPocketCost
    )
  }

  implicit val profileDetailsWrites = new Writes[ProfileDetails] {
    def writes(profileDetails: ProfileDetails) = Json.obj(
      "name" -> profileDetails.name,
      "work" -> profileDetails.work,
      "servicesAndCosts" -> profileDetails.servicesAndCostssbt
    )
  }

  def index() = Action { implicit request: Request[AnyContent] =>
    val json = Json.toJson(SearchResult.list)
    Ok(json);
  }

  def details(key: Int) = Action { implicit request =>
    val result = ProfileDetails.list.filter(_.id == key)
    println(result)
    val json = Json.toJson(result.head)
    Ok(json);
  }

}
