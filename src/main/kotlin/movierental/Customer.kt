package movierental

class Customer(val name: String) {
    private val _rentals = Rentals()

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
        result += "Amount owed is " + _rentals.totalCharge().toString() + "\n"
        result += "You earned " + _rentals.totalFrequentRenterPoints().toString() + " frequent renter points"

        return result
    }
}