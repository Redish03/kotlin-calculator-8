package calculator.domain.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumManagerTest {
    @Test
    fun `숫자 리스트의 원소들을 더한다`() {
        // given:
        val numbers = listOf(1, 2, 5, 6)
        val expectedAnswer = 14

        // when:
        val calculator = SumManager().addAll(numbers)

        // then:
        assertEquals(calculator, expectedAnswer)
    }
}