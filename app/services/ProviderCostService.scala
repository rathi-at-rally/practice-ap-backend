package services
import play.api.libs.json._
import dao.ProviderCost
import dao.ProviderCostDAO
import utilities.Constants

class ProviderCostService{
def fetch_ProviderCosts(key: String): ProviderCost = {
  val providerCostDAO = new ProviderCostDAO()
     val listDWI = providerCostDAO.fetch_list(Constants.path_ProviderCost_json)
     val selectedDWI = listDWI.filter(_.name == key)
     return (selectedDWI.head)
  }
}

