package fr.ensim.areamobility.conducteur.data.service

import fr.ensim.areamobility.conducteur.data.login.User
import java.util.*

data class Service (
    val id: Int,
    val drive: User,
    val StartDate: Calendar,
    val finishDate: Calendar,
    val vehicule: Vehicule
    )