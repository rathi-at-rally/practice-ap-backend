package dao
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class ServicesAndCosts(
    services: String,
    costNear: String,
    estimatedTotalCost: String,
    insurancePays: String,
    estimatedOutOfPocketCost: String
)

object ServicesAndCosts{
  implicit val writes_SAC = new Writes[ServicesAndCosts] {
      def writes(val_SAC: ServicesAndCosts) = Json.obj(
        "services" -> val_SAC.services,
        "costNear" -> val_SAC.costNear,
        "estimatedTotalCost" -> val_SAC.estimatedTotalCost,
        "insurancePays" -> val_SAC.insurancePays,
        "estimatedOutOfPocketCost" -> val_SAC.estimatedOutOfPocketCost
      )
  }

  implicit val reads_SAC: Reads[ServicesAndCosts] = (
      (JsPath \ "services").read[String] and
      (JsPath \ "costNear").read[String] and
      (JsPath \ "estimatedTotalCost").read[String] and
      (JsPath \ "insurancePays").read[String] and
      (JsPath \ "estimatedOutOfPocketCost").read[String]
  )(ServicesAndCosts.apply _)
}