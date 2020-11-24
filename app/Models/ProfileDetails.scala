package Models

case class ProfileDetails(
    id: Integer,
    name: String,
    work: String,
    servicesAndCosts: Seq[SearchSpecific]
)

object ProfileDetails {
  var list: List[ProfileDetails] = {
    List(
      ProfileDetails(
        1,
        "Bailey, Tanya J, MD",
        "Pediatrics",
        SearchSpecific.list
      ),
      ProfileDetails(
        2,
        "Meier, Diane M, MD",
        "Pediatrics",
        SearchSpecific.list
      ),
      ProfileDetails(
        3,
        "Pflaster, Gregory J, Jr, MD",
        "Urgent Care Medicine, Family Practice",
        SearchSpecific.list
      ),
      ProfileDetails(
        4,
        "Phillips, Daniela M, MD",
        "Pediatrics",
        SearchSpecific.list
      ),
      ProfileDetails(
        5,
        "Swan, Thomas T, MD",
        "Family Practice",
        SearchSpecific.list
      )
    )
  }
}
