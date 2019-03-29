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
}

class ChildrensPrice: Price {
    override fun getPriceCode(): Int {
        return Movie.CHILDRENS
    }
}

class NewReleasePrice: Price {
    override fun getPriceCode(): Int {
        return Movie.NEW_RELEASE
    }
}

class RegularPrice: Price {
    override fun getPriceCode(): Int {
        return Movie.REGULAR
    }
}
