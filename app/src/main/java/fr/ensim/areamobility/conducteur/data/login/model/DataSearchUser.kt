package fr.ensim.areamobility.conducteur.data.login.model

data class DataSearchUser(
    val email: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val passwd: String,
    val tel: String
)