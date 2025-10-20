package calculator

import calculator.domain.NumberValidator
import calculator.domain.ParserClassifier

fun main() {
    Controller(
        parserClassifier = ParserClassifier(),
        numberValidator = NumberValidator()
    ).run()
}
