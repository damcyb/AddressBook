package addressBookSystem.model

import java.lang.RuntimeException

class PersonNotFoundException(message: String): RuntimeException(message)