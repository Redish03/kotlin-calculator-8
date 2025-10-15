package calculator.domain

interface Parser {
    fun parseBySeparator(separator: Char): List<Int>
}