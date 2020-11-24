package Models

case class SearchSpecific(
    services: String,
    costNear: String,
    estimatedTotalCost: String,
    insurancePays: String,
    estimatedOutOfPocketCost: String
)

object SearchSpecific {
  var list: List[SearchSpecific] = {
    List(
      SearchSpecific(
        "Services Office Visit - Primary Doctor - Established Patient - High Complexity",
        "$302 - $377",
        "Below Average Cost",
        "* N/A",
        "* N/A"
      ),
      SearchSpecific(
        "Office Visit - Primary Doctor - Established Patient - Minimal Complexity",
        "$42 - $52",
        "Cost Not Available",
        "* N/A",
        "* N/A"
      ),
      SearchSpecific(
        "Office Visit - Primary Doctor - Established Patient - Moderate Complexity",
        "C$145 - $188",
        "Below Average Cost ",
        "* N/A",
        "* N/A"
      ),
      SearchSpecific(
        "Office Visit - Primary Doctor - New Patient - High Complexity",
        "$420 - $550",
        "Below Average Cost",
        "* N/A",
        "* N/A"
      )
    )
  }
}
