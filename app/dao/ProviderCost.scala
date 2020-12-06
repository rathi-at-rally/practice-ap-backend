package dao
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class ProviderCost(
  name: String,
  work: String,
  servicesAndCosts: List[ServicesAndCosts]
                       )

object ProviderCost{
  implicit val writes_ProviderServices = new Writes[ProviderCost] {
    def writes(val_PS: ProviderCost) = Json.obj(
      "name" -> val_PS.name,
      "work" -> val_PS.work,
      "servicesAndCosts" -> val_PS.servicesAndCosts
    )
  }

  implicit val reads_ProviderServices: Reads[ProviderCost] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "work").read[String] and
      (JsPath \ "servicesAndCosts").read[List[ServicesAndCosts]]
    )(ProviderCost.apply _)
}

class ProviderCostDAO extends DAOFactory{

  def fetch_list(pathJson: String): List[ProviderCost] =
  {
    val strFormat = scala.io.Source.fromFile(pathJson).mkString
    val listFormat = Json.parse(strFormat).as[List[ProviderCost]]
    return listFormat
  }

}