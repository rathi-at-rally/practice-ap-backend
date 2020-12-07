package services
import utilities.Constants
import dao.Users
import dao.UsersDAO
import javax.inject.{Inject}

class UserService @Inject() (val usersDAO: UsersDAO){

    def validate(qid: String, qemail: String, qpassword: String):Boolean = {
        val listCredentials = usersDAO.fetch_list(Constants.path_Users_json)
        val valid = listCredentials.contains(Users(qid, qemail, qpassword))
        valid
    }
}

    