package calculator.domain

class CustomParser : Parser{
    override fun parseBySeparator(command: String): List<Int> {
        val separator = recognizeSeparator(command)
        return parseByCustomSeparator(separator, command)
    }

    fun recognizeSeparator(command: String): String = command.substringAfter("//").substringBefore("\\n")
}