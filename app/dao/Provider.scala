package dao

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Provider (
    name: String,
    work: String,
    address1: String,
    address2: String,
    contact: String,
    vicinity: String
)

object Provider{

  implicit val writes_Providers = new Writes[Provider] {
    def writes(val_Providers: Provider) = Json.obj(
      "name" -> val_Providers.name,
      "work" -> val_Providers.work,
      "address1" -> val_Providers.address1,
      "address2" -> val_Providers.address2,
      "contact" -> val_Providers.contact,
      "vicinity" -> val_Providers.vicinity
    )
  }

  implicit val reads_Provider: Reads[Provider] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "work").read[String] and
      (JsPath \ "address1").read[String] and
      (JsPath \ "address2").read[String] and
      (JsPath \ "contact").read[String] and
      (JsPath \ "vicinity").read[String]
    )(Provider.apply _)

}

class ProviderDAO extends DAOFactory{

  def fetch_list(pathJson: String): List[Provider] =
  {
    val strFormat = scala.io.Source.fromFile(pathJson).mkString
    val listFormat = Json.parse(strFormat).as[List[Provider]]
    return listFormat
  }

}

