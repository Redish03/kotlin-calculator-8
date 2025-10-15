package calculator.domain

interface Parser {
    fun parseBySeparator(command: String): List<Int>
}