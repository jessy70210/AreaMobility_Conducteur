package fr.ensim.areamobility.conducteur.service

import fr.ensim.areamobility.conducteur.data.login.TypeProfile
import fr.ensim.areamobility.conducteur.data.login.User
import fr.ensim.areamobility.conducteur.tools.Hash

class UserService {
    companion object {
        val Users = listOf<User>(
            User(
                1,
                "Estelle",
                "Ganot",
                "Estelle.Ganot.Etu@univ-lemans.fr",
                Hash.md5("Estelle"),
                TypeProfile.DRIVER
            ),
            User(
                2,
                "Dylan",
                "Jacquot",
                "Dylan.Jacquot.Etu@univ-lemans.fr",
                Hash.md5("Dylan"),
                TypeProfile.DRIVER
            ),
            User(
                3,
                "Kevin",
                "Zemsi",
                "Kevin.Zemsi.Etu@univ-lemans.fr",
                Hash.md5("Kevin"),
                TypeProfile.DRIVER
            ),
            User(
                3,
                "Kevin",
                "Zemsi",
                "Kevin.Zemsi.Etu@univ-lemans.fr",
                Hash.md5("Kevin"),
                TypeProfile.TRAVELER
            )
        )
    }
}