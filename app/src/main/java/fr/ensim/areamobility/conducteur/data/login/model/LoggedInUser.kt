package fr.ensim.areamobility.conducteur.data.login.model

import fr.ensim.areamobility.conducteur.data.login.User

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userUid: String,
    val user : User
//    val userIdDbb: String,
//    val displayName: String
)