import addressBookSystem.model.Address
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class AddressTest {

    @Test
    fun initializedAddressShouldHaveProperData() {
        //given
        val address = Address("Poznan", "Grunwaldzka", "14", "123123")
        //when
        //then
        assertThat(address.city, equalTo("Poznan"))
        assertThat(address.street, equalTo("Grunwaldzka"))
        assertThat(address.number, equalTo("14"))
        assertThat(address.postalCode, equalTo("123123"))
    }
}