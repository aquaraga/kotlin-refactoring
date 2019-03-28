package movierental

/**
 * The rental class represents a customer renting a movie.
 */
class Rental(val movie: Movie, val daysRented: Int) {
    fun getCharge(): Double {
        var amount = 0.0

        //determine amounts for each line
        when (movie.priceCode) {
            Movie.REGULAR -> {
                amount += 2.0
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5
            }
            Movie.NEW_RELEASE -> amount += (daysRented * 3).toDouble()
            Movie.CHILDRENS -> {
                amount += 1.5
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5
            }
        }
        return amount
    }

    fun getFrequentRenterPoints(): Int {
        var eachRenterPoints = 0
        // add frequent renter points
        eachRenterPoints++
        // add bonus for a two day new release rental
        if (movie.priceCode == Movie.NEW_RELEASE && daysRented > 1)
            eachRenterPoints++
        return eachRenterPoints
    }
}