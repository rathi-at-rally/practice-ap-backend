package Models

case class SearchResult(
    name: String,
    work: String,
    address1: String,
    address2: String,
    location: String,
    vicinity: String
)

object SearchResult {
  var list: List[SearchResult] = {
    List(
      SearchResult(
        "Bailey, Tanya J, MD",
        "Pediatrics",
        "12720 Bass Lake Rd",
        "Maple Grove, MN 55369",
        "(763) 559-2861 PHONE",
        "0.7 Miles Away"
      ),
      SearchResult(
        "Meier, Diane M, MD",
        "Pediatrics",
        "12720 Bass Lake Rd",
        "Maple Grove, MN 55369",
        "(763) 559-2861 PHONE",
        "0.7 Miles Away"
      ),
      SearchResult(
        "Pflaster, Gregory J, Jr, MD",
        "Urgent Care Medicine, Family Practice",
        "12720 Bass Lake Rd",
        "Maple Grove, MN 55369",
        "(763) 559-2861 PHONE",
        "0.7 Miles Away"
      ),
      SearchResult(
        "Phillips, Daniela M, MD",
        "Pediatrics",
        "12720 Bass Lake Rd",
        "Maple Grove, MN 55369",
        "(763) 559-2861 PHONE",
        "0.7 Miles Away"
      ),
      SearchResult(
        "Swan, Thomas T, MD",
        "Family Practice",
        "12720 Bass Lake Rd",
        "Maple Grove, MN 55369",
        "(763) 559-2861 PHONE",
        "0.7 Miles Away"
      )
    )
  }
}
