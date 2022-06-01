package fr.ensim.areamobility.conducteur.data.login

data class User (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val type:TypeProfile
)

enum class TypeProfile {
    DRIVER, CONTROLLER, ADMINISTRATION, TRAVELER
}