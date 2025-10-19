package calculator.domain

class StandardParser : Parser {
    override fun parseBySeparator(command: String): List<Int> = parseByCommaAndColon(command)

    private fun parseByCommaAndColon(command: String): List<Int> =
        command.split(COMMA_DELIMITER, COLON_DELIMITER)
            .map { it.trim() }
            .map { it.toInt() }

    companion object {
        const val COMMA_DELIMITER = ','
        const val COLON_DELIMITER = ':'
    }
}