package services

import dao.Provider
import dao.ProviderDAO
import utilities.Constants

class ProviderService {
  def fetch_Provider(searchString: String): List[Provider] = {
    val providerDAO = new ProviderDAO()
    val listDGI = providerDAO.fetch_list(Constants.path_Provider_json)
    searchString match {
      case "ALL" => listDGI
      case _ => listDGI.filter(_.name.contains(searchString))
    }
  }
}