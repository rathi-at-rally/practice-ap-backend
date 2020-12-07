package services
import play.api.libs.json._
import dao.ProviderCost
import dao.ProviderCostDAO
import utilities.Constants
import javax.inject.{Inject}

class ProviderCostService @Inject() (val providerCostDAO: ProviderCostDAO){
def fetch_ProviderCosts(key: String): ProviderCost = {
     val result = providerCostDAO.fetch_specific(Constants.path_ProviderCost_json, key )
     return (result)
  }
}

