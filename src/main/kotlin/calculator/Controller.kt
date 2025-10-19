package calculator

import calculator.domain.Parser
import calculator.domain.calculator.SumManager
import calculator.view.InputManager

class Controller {
    val inputManager: InputManager = InputManager()
    val sumManager: SumManager = SumManager()

    fun run() {
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