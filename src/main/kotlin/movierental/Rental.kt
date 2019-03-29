package movierental

/**
 * The rental class represents a customer renting a movie.
 */
class Rental(val movie: Movie, val daysRented: Int) {
    fun getCharge(): Double {
        return movie.getCharge(daysRented)
    }



    fun getFrequentRenterPoints(): Int {
        return movie.getFrequentRenterPoints(daysRented)
    }
}