package calculator.domain

class NumberValidator {
    fun validateNumbers(numbers: List<Int>) {
        for (number in numbers) {
            if (number <= REFERENCE_POINT_POSITIVE_NUMBER) {
                throw IllegalArgumentException("숫자는 양수를 입력해주세요")
            }
        }
    }

    companion object {
        const val REFERENCE_POINT_POSITIVE_NUMBER = 0
    }
}