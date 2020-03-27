import addressBookSystem.Book
import addressBookSystem.model.Address
import addressBookSystem.model.Person
import addressBookSystem.model.PersonNotFoundException
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class BookTest {

    companion object {
        lateinit var book: Book

        @BeforeAll
        @JvmStatic
        fun setup() {
            book = Book()
        }
    }

    @AfterEach
    fun clearPersonList() {
        book.personList.clear()
    }

    @Test
    fun addingNewPersonShouldIncreaseBookSize() {
        //given
        val address = Address("Poznan", "Grunwaldzka", "14", "123123")
        val person = Person("Adam", "Malysz", "123123123", address)
        book.addPerson(person)

        //then
        assertThat(book.personList.size, equalTo(1))
    }

    @Test
    fun removingPersonShouldDecreaseBookSize() {
        //given
        val address = Address("Poznan", "Grunwaldzka", "14", "123123")
        val person = Person("Adam", "Malysz", "123123123", address)
        val removedPerson = Person("Adam", "Malysz", "123123123", address)
        book.addPerson(removedPerson)

        //when
        book.removePerson(person)

        //then
        assertThat(book.personList.size, equalTo(0))
    }

    @Test
    fun personAddedToBookShouldBeNotDuplicated() {
        //given
        val address = Address("Poznan", "Grunwaldzka", "14", "123123")
        val person = Person("Adam", "Malysz", "123123123", address)
        book.addPerson(person)

        //then
        assertThrows(IllegalArgumentException::class.java) {
            book.addPerson(person)
        }
    }

    @Test
    fun onlyPersonAlreadyExistingInBookCouldBeRemoved() {
        //given
        val address = Address("Poznan", "Grunwaldzka", "14", "123123")
        val person = Person("Adam", "Malysz", "123123123", address)

        //then
        assertThrows(PersonNotFoundException::class.java) {
            book.removePerson(person)
        }
    }

    @Test
    fun modifiedPersonShouldBeUpdated() {
        //given
        val address = Address("Poznan", "Grunwaldzka", "14", "123123")
        val updatedAddress = Address("Poznan", "Grunwaldzka", "14", "123123")
        val person = Person("Adam", "Malysz", "123123123", address)
        val updatedPerson = Person("Piotr", "Malysz", "12341234", updatedAddress)
        book.addPerson(person)

        //when
        book.modifyPerson(person.firstName, person.lastName , updatedPerson)
        val personInUpdatedBook = book.findPersonByName(updatedPerson.firstName, updatedPerson.lastName)
        //then
        assertThat(personInUpdatedBook.firstName, equalTo(updatedPerson.firstName))
        assertThat(personInUpdatedBook.lastName, equalTo(updatedPerson.lastName))
        assertThat(personInUpdatedBook.phoneNumber, equalTo(updatedPerson.phoneNumber))
        assertThat(personInUpdatedBook.address, equalTo(updatedPerson.address))
    }

    @Test
    fun lookingForPersonWhoIsNotInBookShouldThrowException() {
        //given
        val address = Address("Poznan", "Grunwaldzka", "14", "123123")
        val person = Person("Adam", "Malysz", "123123123", address)

        //then
        assertThrows(PersonNotFoundException::class.java) {
            book.findPersonByName(person.firstName, person.lastName)
        }
    }

}