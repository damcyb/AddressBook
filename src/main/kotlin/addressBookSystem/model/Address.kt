package addressBookSystem.model

class Address(
    internal val city: String,
    internal val street: String,
    internal val number: String,
    internal val postalCode: String
) {
    override fun toString(): String {
        return "Address(city='$city', street='$street', number='$number', postalCode='$postalCode')"
    }
}