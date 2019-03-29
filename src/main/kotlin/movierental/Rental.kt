package movierental

/**
 * The rental class represents a customer renting a movie.
 */
class Rental(val movie: Movie, val daysRented: Int) {
    fun getCharge(): Double {
        return movie.getCharge(daysRented)
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