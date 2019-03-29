package movierental

class Movie(val title: String, var priceCode: Int) {
    companion object {
        val CHILDRENS = 2
        val NEW_RELEASE = 1
        val REGULAR = 0
    }

    fun getCharge(_daysRented: Int): Double {
        var amount = 0.0

        //determine amounts for each line
        when (priceCode) {
            Movie.REGULAR -> {
                amount += 2.0
                if (_daysRented > 2)
                    amount += (_daysRented - 2) * 1.5
            }
            Movie.NEW_RELEASE -> amount += (_daysRented * 3).toDouble()
            Movie.CHILDRENS -> {
                amount += 1.5
                if (_daysRented > 3)
                    amount += (_daysRented - 3) * 1.5
            }
        }
        return amount
    }

    fun getFrequentRenterPoints(daysRented: Int): Int {
        var eachRenterPoints = 0
        // add frequent renter points
        eachRenterPoints++
        // add bonus for a two day new release rental
        if (price.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            eachRenterPoints++
        return eachRenterPoints
    }
}