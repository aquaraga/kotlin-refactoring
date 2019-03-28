package movierental

import java.util.ArrayList

class Customer(val name: String) {
    private val _rentals = ArrayList<Rental>()

    fun addRental(arg: Rental) {
        _rentals.add(arg)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        var result = "Rental Record for $name\n"

        for (each in _rentals) {

            // add frequent renter points
            frequentRenterPoints++
            // add bonus for a two day new release rental
            if (each.movie.priceCode == Movie.NEW_RELEASE && each.daysRented > 1)
                frequentRenterPoints++

            // show figures for this rental
            result += "\t" + each.movie.title + "\t" + each.getCharge().toString() + "\n"
            totalAmount += each.getCharge()
        }

        // add footer lines
        result += "Amount owed is " + totalAmount.toString() + "\n"
        result += "You earned " + frequentRenterPoints.toString() + " frequent renter points"

        return result
    }
}