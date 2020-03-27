package addressBookSystem

import addressBookSystem.model.Address
import addressBookSystem.model.Person
import java.util.*

class BookFacade {

    private val book = Book()

    fun showOptions() {
        println("1 - show all records in book")
        println("2 - add new person")
        println("3 - remove person")
        println("4 - update person")
        println("5 - find person by name")
    }

    fun getUserChoice(): String {
        val scanner = Scanner(System.`in`)
        return scanner.nextLine()
    }

    fun operateUserChoice(input: String) {
        when (input) {
            "1" -> showAllRecordsInBook()
            "2" -> addNewPersonToBook()
            "3" -> removePersonFromBook()
            "4" -> updatePersonInBook()
            "5" -> findPersonInBook()
        }
    }

    private fun showAllRecordsInBook() {
        book.showBook()
    }

    private fun addNewPersonToBook() {
        val person = fillFullPersonForm()
        book.addPerson(person)
    }

    private fun fillFullPersonForm(): Person {
        val scanner = Scanner(System.`in`)
        println("Type first name: ")
        val firstName = scanner.nextLine()
        println("Type last name: ")
        val lastName = scanner.nextLine()
        println("Type phone number: ")
        val phoneNumber = scanner.nextLine()
        println("Type city: ")
        val city = scanner.nextLine()
        println("Type street: ")
        val street = scanner.nextLine()
        println("Type number: ")
        val number = scanner.nextLine()
        println("Type postal code: ")
        val postalCode = scanner.nextLine()

        return Person(firstName, lastName, phoneNumber, Address(city, street, number, postalCode))
    }

    private fun removePersonFromBook() {
        val person = fillShortPersonForm()
        book.removePerson(person)
    }

    private fun fillShortPersonForm(): Person {
        val scanner = Scanner(System.`in`)
        println("Type first name: ")
        val firstName = scanner.nextLine()
        println("Type last name: ")
        val lastName = scanner.nextLine()

        return Person(firstName, lastName, "", Address("", "", "", ""))
    }

    private fun updatePersonInBook() {
        println("Type name of person who would like to update: ")
        val personToUpdate = fillShortPersonForm()
        println("Type new person data: ")
        val updatedPerson = fillFullPersonForm()
        book.modifyPerson(personToUpdate.firstName, personToUpdate.lastName, updatedPerson)
    }

    private fun findPersonInBook() {
        val person = fillShortPersonForm()
        book.findPersonByName(person.firstName, person.lastName)
    }

}