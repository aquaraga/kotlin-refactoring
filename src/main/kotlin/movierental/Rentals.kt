package movierental

class Rentals : ArrayList<Rental>() {
    fun totalCharge(): Double {
        var totalAmount = 0.0
        for (each in this) {
            totalAmount += each.getCharge()
        }
        return totalAmount
    }

    fun totalFrequentRenterPoints(): Int {
        var frequentRenterPoints = 0
        for (each in this) {
            frequentRenterPoints += each.getFrequentRenterPoints()
        }
        return frequentRenterPoints
    }
}
