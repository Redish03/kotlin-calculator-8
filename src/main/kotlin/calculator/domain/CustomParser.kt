package calculator.domain

class CustomParser : Parser{
    override fun parseBySeparator(command: String): List<Int> {
        val separator = recognizeSeparator(command)
        return parseByCustomSeparator(separator, command)
    }

    fun recognizeSeparator(command: String): String = command.substringAfter("//").substringBefore("\\n")

    fun parseByCustomSeparator(separator: String, command: String): List<Int> {
        val numbersString = command.substringAfter("\\n")
        return numbersString.split(separator)
            .map { it.trim() }
            .map { it.toInt() }
    }
}