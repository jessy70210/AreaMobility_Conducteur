package fr.ensim.areamobility.conducteur.service

import fr.ensim.areamobility.conducteur.data.service.Service
import java.util.*
import kotlin.collections.ArrayList

class ServiceService {
    companion object {
        val firstDay : Calendar = Calendar.getInstance()
        val services = ArrayList<Service>()
        private fun test () {
            var firstDate : Calendar = Calendar.getInstance()
            var endDate : Calendar = Calendar.getInstance()
            firstDate.set(2022,6,13,5,0)
            endDate.set(2022,6,13,8,0)
            services.add(Service(1, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

            firstDate = Calendar.getInstance()
            endDate = Calendar.getInstance()
            firstDate.set(2022,6,14,6,30)
            endDate.set(2022,6,14,11,0)
            services.add(Service(2, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

            firstDate = Calendar.getInstance()
            endDate = Calendar.getInstance()
            firstDate.set(2022,6,15,0,30)
            endDate.set(2022,6,15,2,0)
            services.add(Service(3, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

            firstDate = Calendar.getInstance()
            endDate = Calendar.getInstance()
            firstDate.set(2022,6,16,1,0)
            endDate.set(2022,6,16,3,15)
            services.add(Service(4, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

            firstDate = Calendar.getInstance()
            endDate = Calendar.getInstance()
            firstDate.set(2022,6,16,8,0)
            endDate.set(2022,6,16,11,0)
            services.add(Service(5, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

            firstDate = Calendar.getInstance()
            endDate = Calendar.getInstance()
            firstDate.set(2022,6,17,9,0)
            endDate.set(2022,6,17,13,30)
            services.add(Service(6, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

            firstDate = Calendar.getInstance()
            endDate = Calendar.getInstance()
            firstDate.set(2022,6,18,11,30)
            endDate.set(2022,6,18,16,0)
            services.add(Service(7, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

            firstDate = Calendar.getInstance()
            endDate = Calendar.getInstance()
            firstDate.set(2022,6,19,8,0)
            endDate.set(2022,6,19,12,30)
            services.add(Service(8, UserService.Users.get(5), firstDate, endDate, VehiculeService.Vehicules.get(0)))

        }
    }
}