package dao
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Users (
    id: String,
    email: String,
    password: String,
)

object Users{

  implicit val reads_Credentials: Reads[Users] = (
    (JsPath \ "id").read[String] and
      (JsPath \ "email").read[String] and
      (JsPath \ "password").read[String]
    )(Users.apply _)

}

class UsersDAO {

  def fetch_list(pathJson: String): List[Users] =
  {
    val strFormat = scala.io.Source.fromFile(pathJson).mkString
    val listFormat = Json.parse(strFormat).as[List[Users]]

    return listFormat
  }

}



