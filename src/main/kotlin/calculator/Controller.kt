package calculator

import calculator.domain.Parser
import calculator.domain.ParserClassifier
import calculator.domain.calculator.SumManager
import calculator.view.InputManager
import calculator.view.OutputManager

class Controller(private val parserClassifier: ParserClassifier) {
    val outputManager = OutputManager()
    val inputManager = InputManager()
    val sumManager: SumManager = SumManager()

    fun run() {
        outputManager.printGuide()
        val command = inputManager.inputCommandFromUser()
        try {
            val numbers = parseCommand(command)
            isSatisfyCondition(command)
            OutputManager().printResult(sumManager.addAll(numbers))
        } catch (e: IllegalArgumentException) {

        }
    }

    private fun isSatisfyCondition(command: String) {
        TODO("Not yet implemented")
    }

    fun parseCommand(command: String) : List<Int> {
        val parser: Parser = parserClassifier.create(command)
        return parser.parseBySeparator(command)
    }
}