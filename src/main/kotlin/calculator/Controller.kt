package calculator

import calculator.domain.NumberValidator
import calculator.domain.Parser
import calculator.domain.ParserClassifier
import calculator.domain.calculator.SumManager
import calculator.view.InputManager
import calculator.view.OutputManager

class Controller(private val parserClassifier: ParserClassifier, private val numberValidator: NumberValidator) {
    val outputManager = OutputManager()
    val inputManager = InputManager()
    val sumManager: SumManager = SumManager()

    fun run() {
        outputManager.printGuide()
        val command = inputManager.inputCommandFromUser()
        try {
            val numbers = parseCommand(command)
            isSatisfyCondition(numbers)
            OutputManager().printResult(sumManager.addAll(numbers))
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력 값에 양수가 아닌 값이 포함되어 있습니다.", e)
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            throw e
        }
    }

    private fun isSatisfyCondition(numbers: List<Int>) = numberValidator.validateNumbers(numbers)

    fun parseCommand(command: String) : List<Int> {
        val commandParser: Parser = parserClassifier.create(command)
        return commandParser.parseBySeparator(command)
    }
}