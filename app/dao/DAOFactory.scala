package dao

trait DAOFactory{
    def fetch_list(pathJson: String): List[Any]
}