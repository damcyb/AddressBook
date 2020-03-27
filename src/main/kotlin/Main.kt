import addressBookSystem.BookFacade

fun main() {
    val bookFacade = BookFacade()

    while(true) {
        bookFacade.showOptions()
        val input = bookFacade.getUserChoice()
        bookFacade.operateUserChoice(input)
    }
}