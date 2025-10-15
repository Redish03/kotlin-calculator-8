package calculator.domain

class StandardParser : Parser {
    override fun parseBySeparator(command: String): List<Int> = parseByCommaAndColon(command)

    private fun parseByCommaAndColon(command: String): List<Int> =
        command.split(',', ':')
            .map { it.trim() }
            .map { it.toInt() }
}