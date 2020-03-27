import addressBookSystem.model.Address
import addressBookSystem.model.Person
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PersonTest {

    lateinit var address: Address
    lateinit var person: Person

    @BeforeEach
    fun init() {
        address = Address("Poznan", "Grunwaldzka", "14", "123123")
        person = Person("Adam", "Malysz", "123123123", address)
    }

    @Test
    fun initializedPersonShouldHaveProperData() {
        //given

        //when
        //then
        assertThat(person.firstName, equalTo("Adam"))
        assertThat(person.lastName, equalTo("Malysz"))
        assertThat(person.phoneNumber, equalTo("123123123"))
        assertNotNull(person.address)
    }
}
