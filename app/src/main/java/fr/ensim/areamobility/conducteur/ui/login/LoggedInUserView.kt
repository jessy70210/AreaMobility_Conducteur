package fr.ensim.areamobility.conducteur.ui.login

/**
 * Les détails de l'utilisateur après l'authentification qui sont exposés à l'interface utilisateur.
 */
data class LoggedInUserView(
    val displayName: String
    //... other data fields that may be accessible to the UI
)