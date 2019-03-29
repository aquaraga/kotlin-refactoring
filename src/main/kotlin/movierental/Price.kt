package movierental

interface Price {
    companion object {
        fun fromCode(priceCode: Int): Price {
            return when(priceCode) {
                Movie.REGULAR -> RegularPrice()
                Movie.NEW_RELEASE -> NewReleasePrice()
                Movie.CHILDRENS -> ChildrensPrice()
                else -> throw IllegalArgumentException("Invalid price code $priceCode")
            }
        }
    }
    fun getPriceCode(): Int
    fun getCharge(_daysRented: Int): Double
}

class ChildrensPrice: Price {
    override fun getCharge(_daysRented: Int): Double {
        var amount = 1.5
        if (_daysRented > 3)
            amount += (_daysRented - 3) * 1.5
        return amount
    }

    override fun getPriceCode(): Int {
        return Movie.CHILDRENS
    }
}

class NewReleasePrice: Price {
    override fun getCharge(_daysRented: Int): Double {
        return (_daysRented * 3).toDouble()
    }

    override fun getPriceCode(): Int {
        return Movie.NEW_RELEASE
    }
}

class RegularPrice: Price {
    override fun getCharge(_daysRented: Int): Double {
        var amount = 2.0
        if (_daysRented > 2)
            amount += (_daysRented - 2) * 1.5
        return amount
    }

    override fun getPriceCode(): Int {
        return Movie.REGULAR
    }
}
