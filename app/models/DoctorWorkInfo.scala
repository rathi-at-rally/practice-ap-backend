package models

case class DoctorWorkInfo(
    name: String,
    work: String,
    servicesAndCosts: List[ServicesAndCosts]
)
