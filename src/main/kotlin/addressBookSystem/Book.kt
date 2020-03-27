package addressBookSystem

import addressBookSystem.model.Person
import addressBookSystem.model.PersonNotFoundException

internal class Book {
    internal val personList = arrayListOf<Person>()

    internal fun addPerson(person: Person) {
        val isDuplicate = personList.filter { it == person }.any()
        if(!isDuplicate) {
            personList.add(person)
        } else {
            throw IllegalArgumentException("Passed person already exists in book")
        }
    }

    internal fun removePerson(person: Person) {
        val person = personList.find { it.firstName == person.firstName && it.lastName == person.lastName }
        if (person != null) {
            personList.remove(person)
        } else {
            throw PersonNotFoundException("Person is not in book")
        }
    }

    internal fun modifyPerson(firstName: String, lastName: String, person: Person) {
        var foundPerson = findPersonByName(firstName, lastName)
        val index = personList.indexOf(foundPerson)
        personList[index] = person
    }

    internal fun findPersonByName(firstName: String, lastName: String): Person {
        val person =  personList.find { it.firstName == firstName && it.lastName == lastName }
        if(person != null) {
            println(person)
            return person
        } else {
            throw PersonNotFoundException("addressBookSystem.model.Person not found")
        }
    }

    internal fun showBook() {
        personList.forEach {
            println(it)
        }
    }
}
