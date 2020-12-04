package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import models.ServicesAndCosts
import models.DoctorGeneralInfo
import models.DoctorWorkInfo
import models.Credentials
import java.awt.Desktop.Action

@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {


// Path to DGI and DWI Json files
  val path_DGI_repo = "app/storage/DGI_List.json"
  val path_DWI_repo = "app/storage/DWI_List.json"
  val path_Credentials_repo = "app/storage/Credentials.json"


// Implicit Writes for DGI, DWI & SAC
  implicit val writes_SAC = new Writes[ServicesAndCosts] {
    def writes(val_SAC: ServicesAndCosts) = Json.obj(
      "services" -> val_SAC.services,
      "costNear" -> val_SAC.costNear,
      "estimatedTotalCost" -> val_SAC.estimatedTotalCost,
      "insurancePays" -> val_SAC.insurancePays,
      "estimatedOutOfPocketCost" -> val_SAC.estimatedOutOfPocketCost
    )
  }

  implicit val writes_DWI = new Writes[DoctorWorkInfo] {
    def writes(val_DWI: DoctorWorkInfo) = Json.obj(
      "name" -> val_DWI.name,
      "work" -> val_DWI.work,
      "servicesAndCosts" -> val_DWI.servicesAndCosts
    )
  }

  implicit val writes_DGI = new Writes[DoctorGeneralInfo] {
    def writes(val_DGI: DoctorGeneralInfo) = Json.obj(
      "name" -> val_DGI.name,
      "work" -> val_DGI.work,
      "address1" -> val_DGI.address1,
      "address2" -> val_DGI.address2,
      "contact" -> val_DGI.contact,
      "vicinity" -> val_DGI.vicinity
    )
  }



// Implicit Reads for DGI, DWI, SAC & Credentials
  implicit val reads_SAC: Reads[ServicesAndCosts] = (
    (JsPath \ "services").read[String] and
      (JsPath \ "costNear").read[String] and
      (JsPath \ "estimatedTotalCost").read[String] and
      (JsPath \ "insurancePays").read[String] and
      (JsPath \ "estimatedOutOfPocketCost").read[String]
  )(ServicesAndCosts.apply _)

  implicit val reads_DWI: Reads[DoctorWorkInfo] = (
      (JsPath \ "name").read[String] and
      (JsPath \ "work").read[String] and
      (JsPath \ "servicesAndCosts").read[List[ServicesAndCosts]]
  )(DoctorWorkInfo.apply _)

  implicit val reads_DGI: Reads[DoctorGeneralInfo] = (
      (JsPath \ "name").read[String] and
      (JsPath \ "work").read[String] and
      (JsPath \ "address1").read[String] and
      (JsPath \ "address2").read[String] and
      (JsPath \ "contact").read[String] and
      (JsPath \ "vicinity").read[String]
  )(DoctorGeneralInfo.apply _)

  implicit val reads_Credentials: Reads[Credentials] = (
      (JsPath \ "id").read[String] and
      (JsPath \ "email").read[String] and
      (JsPath \ "password").read[String]
  )(Credentials.apply _)



// API to fetch a specific DGI based on name
  def fetch_specificDoctorGeneralInfo(searchString: String) = Action { implicit request =>
    val strDGI = scala.io.Source.fromFile(path_DGI_repo).mkString
    val listDGI = Json.parse(strDGI).as[List[DoctorGeneralInfo]]
    searchString match {
      case "ALL" => Ok(Json.toJson(listDGI))
      case _ => Ok(Json.toJson(listDGI.filter(_.name.contains(searchString))))
    }
  }

// API to fetch a specific DWI based on name
  def fetch_specificDoctorWorkInfo(key: String) = Action { implicit request =>
    val strDWI = scala.io.Source.fromFile(path_DWI_repo).mkString
    val listDWI = Json.parse(strDWI).as[Seq[DoctorWorkInfo]]
    val selectedDWI = listDWI.filter(_.name == key)
    Ok(Json.toJson(selectedDWI.head));
  }

  // API to validate Credentials
  def validate_credentials(qid: String, qemail: String, qpassword: String) = Action { implicit request =>
    val strCredentials = scala.io.Source.fromFile(path_Credentials_repo).mkString
    val listCredentials = Json.parse(strCredentials).as[List[Credentials]]
    val validate = listCredentials.contains(Credentials(qid, qemail, qpassword))
    Ok(validate.toString)
  }
}
