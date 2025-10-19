package calculator

import calculator.domain.Parser
import calculator.domain.calculator.SumManager
import calculator.view.InputManager
import calculator.view.OutputManager

class Controller {
    val outputManager = OutputManager()
    val inputManager = InputManager()
    val sumManager: SumManager = SumManager()

    fun run() {
        outputManager.printGuide()
        val command = inputManager.inputCommandFromUser()
        try {
            isSatisfyCondition(command)
            val numbers = parseCommand(command)
            OutputManager().printResult(sumManager.addAll(numbers))
        } catch (e: IllegalArgumentException) {

        }
    }

    private fun isSatisfyCondition(command: String) {
        TODO("Not yet implemented")
    }

    fun parseCommand(command: String) : List<Int> {

    }
}