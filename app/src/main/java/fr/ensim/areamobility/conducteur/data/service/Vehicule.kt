package fr.ensim.areamobility.conducteur.data.service

data class Vehicule (
    val registration: String,
    val libelle: String,
    val infos: ArrayList<Info>
    )