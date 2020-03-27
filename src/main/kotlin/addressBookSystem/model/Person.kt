package addressBookSystem.model

class Person(
    internal var firstName: String,
    internal var lastName: String,
    internal val phoneNumber: String,
    internal val address: Address
) {
    override fun toString(): String {
        return "Person(firstName='$firstName', lastName='$lastName', phoneNumber='$phoneNumber', address=$address)"
    }

}
