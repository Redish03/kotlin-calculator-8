package calculator.domain

class CustomParser : Parser{
    override fun parseBySeparator(command: String): List<Int> {
        val separator = recognizeSeparator(command)
        return parseByCustomSeparator(separator, command)
    }

    fun recognizeSeparator(command: String): String = command.substringAfter(CUSTOM_SEPARATOR_PREFIX).substringBefore(CUSTOM_SEPARATOR_TERMINATOR)

    fun parseByCustomSeparator(separator: String, command: String): List<Int> {
        val numbersString = command.substringAfter(CUSTOM_SEPARATOR_TERMINATOR)
        return numbersString.split(separator)
            .map { it.trim() }
            .map { it.toInt() }
    }

    companion object {
        const val CUSTOM_SEPARATOR_PREFIX: String = "//"
        const val CUSTOM_SEPARATOR_TERMINATOR: String = "\\n"
    }
}