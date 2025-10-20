package calculator.domain

class StandardParser : Parser {
    override fun parseBySeparator(command: String): List<Int> {
        checkEmptyCommand(command)
        val result = parseByCommaAndColon(command)
        return result
    }

    private fun parseByCommaAndColon(command: String): List<Int> =
        command.split(COMMA_DELIMITER, COLON_DELIMITER)
            .map { it.trim() }
            .map { it.toInt() }

    fun checkEmptyCommand(command: String) {
        if (command == null) throw IllegalArgumentException("Command cannot be null")
        if (command == "") throw IllegalArgumentException("Command can't be empty")
    }

    companion object {
        const val COMMA_DELIMITER = ','
        const val COLON_DELIMITER = ':'
    }
}