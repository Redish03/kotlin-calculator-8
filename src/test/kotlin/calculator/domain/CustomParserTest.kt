package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CustomParserTest {
    @Test
    fun `커스텀 구분자를 추출한다`() {
        // given:
        val testCommand = "//;\\n1;2;3"
        val testSeparator = ";"

        // when:
        val result = CustomParser().recognizeSeparator(testCommand)

        // then:
        assertEquals(result, testSeparator)
    }

    @Test
    fun `n 앞의 문자열은 버린다`(){
        // given:
        val testCommand = "//;\\n1;2;3"
        val expectedResult = "1;2;3"

        // when:
        val result = testCommand.substringAfter("\\n")

        // then:
        assertEquals(result, expectedResult)
    }

    @Test
    fun `커스텀 구분자로 문자열을 파싱한다`(){
        // given:
        val testCommand = "//;\\n1;2;3"
        val expectedResult = listOf<Int>(1, 2, 3)

        // when:
        val result = CustomParser().parseBySeparator(testCommand)

        // then:
        assertEquals(result, expectedResult)
    }
}