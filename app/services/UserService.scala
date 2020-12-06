package services
import utilities.Constants
import dao.Users
import dao.UsersDAO

class UserService{

    def validate(qid: String, qemail: String, qpassword: String):Boolean = {
        val usersDAO = new UsersDAO()
        val listCredentials = usersDAO.fetch_list(Constants.path_Users_json)
        val valid = listCredentials.contains(Users(qid, qemail, qpassword))
        valid
    }
}

    