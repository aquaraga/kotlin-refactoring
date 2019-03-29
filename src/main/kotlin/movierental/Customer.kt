package movierental

import java.util.ArrayList

class Customer(val name: String) {
    private val _rentals = ArrayList<Rental>()

    fun addRental(arg: Rental) {
        _rentals.add(arg)
    }

    fun statement(): String {
        var result = "Rental Record for $name\n"
        for (each in _rentals) {
            // show figures for this rental
            result += "\t" + each.movie.title + "\t" + each.getCharge().toString() + "\n"
        }
        // add footer lines
        result += "Amount owed is " + totalCharge().toString() + "\n"
        result += "You earned " + totalFrequentRenterPoints().toString() + " frequent renter points"

        return result
    }

    private fun totalCharge(): Double {
        var totalAmount = 0.0
        for (each in _rentals) {
            totalAmount += each.getCharge()
        }
        return totalAmount
    }

    private fun totalFrequentRenterPoints(): Int {
        var frequentRenterPoints = 0
        for (each in _rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints()
        }
        return frequentRenterPoints

    }
}