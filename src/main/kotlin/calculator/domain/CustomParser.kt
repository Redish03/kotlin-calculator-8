package calculator.domain

class CustomParser : Parser{
    override fun parseBySeparator(command: String): List<Int> {
        checkEmptyCommand(command)
        val separator = recognizeSeparator(command)
        checkSeparator(separator)
        val result = parseByCustomSeparator(separator, command)

        return result
    }

    fun recognizeSeparator(command: String): String = command.substringAfter(CUSTOM_SEPARATOR_PREFIX).substringBefore(CUSTOM_SEPARATOR_TERMINATOR)

    fun parseByCustomSeparator(separator: String, command: String): List<Int> {
        val numbersString = command.substringAfter(CUSTOM_SEPARATOR_TERMINATOR)
        return numbersString.split(separator)
            .map { it.trim() }
            .map { it.toInt() }
    }

    fun checkEmptyCommand(command: String) {
        if (command == null) throw IllegalArgumentException("Command cannot be null")
        if (command == EMPTY_STRING) throw IllegalArgumentException("Command can't be empty")
    }

    fun checkSeparator(separator: String) {
        if(separator.length > MAX_SEPARATOR) throw IllegalArgumentException("Separator cannot be over two")
    }

    companion object {
        const val CUSTOM_SEPARATOR_PREFIX: String = "//"
        const val CUSTOM_SEPARATOR_TERMINATOR: String = "\\n"
        const val EMPTY_STRING = ""
        const val MAX_SEPARATOR = 1
    }
}