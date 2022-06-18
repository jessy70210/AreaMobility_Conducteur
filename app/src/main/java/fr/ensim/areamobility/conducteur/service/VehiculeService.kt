package fr.ensim.areamobility.conducteur.service

import fr.ensim.areamobility.conducteur.data.service.Info
import fr.ensim.areamobility.conducteur.data.service.Vehicule

class VehiculeService {
    companion object {
        val Vehicules = listOf<Vehicule>(
            Vehicule("AA 123 BB", "V3", ArrayList<Info>()),
            Vehicule("BB 321 AA", "V1", ArrayList<Info>())
        )
    }
}