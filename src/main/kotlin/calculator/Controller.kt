package calculator

import calculator.domain.Parser
import calculator.domain.calculator.SumManager
import calculator.view.InputManager

class Controller {
    val inputManager: InputManager = InputManager()
    val sumManager: SumManager = SumManager()

    fun run() {
        val command = inputManager.inputCommandFromUser()
        val numbers = parseCommand(command)

        OutputManager().printResult(sumManager.addAll(numbers))
    }

    fun parseCommand(command: String) : List<Int> {

    }
}