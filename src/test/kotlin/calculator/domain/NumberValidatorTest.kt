package calculator.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberValidatorTest {
    @Test
    fun `주어진 숫자 리스트가 양수가 아니라면 IllegalArgumentException을 발생시킨다`() {
        // given
        val testNumbers = listOf(1, 0, 5)

        // when && then
        assertThrows<IllegalArgumentException> {
            NumberValidator().validateNumbers(testNumbers)
        }
    }
}