package services

import dao.Provider
import dao.ProviderDAO
import javax.inject.Inject
import utilities.Constants

class ProviderService @Inject() (val providerDAO: ProviderDAO) {
  def fetch_Provider(searchString: String): List[Provider] = {
    val result = providerDAO.fetch_list_by_searchString(Constants.path_Provider_json, searchString )
    return result
  }
}