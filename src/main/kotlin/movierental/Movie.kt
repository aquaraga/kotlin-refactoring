package movierental

class Movie {
    var title: String
        private set

    private var price: Price

    constructor(title: String, priceCode: Int) {
        this.title = title
        this.price = Price.fromCode(priceCode)
    }

    companion object {
        val CHILDRENS = 2
        val NEW_RELEASE = 1
        val REGULAR = 0
    }

    fun getCharge(_daysRented: Int): Double {
        return price.getCharge(_daysRented)
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