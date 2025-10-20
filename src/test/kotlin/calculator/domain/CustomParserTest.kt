package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `여러 개의 커스텀 구분자를 넣을 경우 IllegalArgumentException을 발생시킨다`() {
        val testCommand = "//,;\\n1;;2;;3"
        assertThrows<IllegalArgumentException> {
             CustomParser().parseBySeparator(testCommand)
        }
    }

    @Test
    fun `주어진 명령어에 빈칸과 숫자가 섞여있다면 IllegalArgumentException을 발생시킨다` () {
        val testCommand = "//;\\n1;;3"

        assertThrows<IllegalArgumentException> {
            CustomParser().parseBySeparator(testCommand)
        }
    }

    @Test
    fun `주어진 명령어에 숫자가 아닌 값이 있다면 IllegalArgumentException을 발생시킨다` () {
        val testCommand = "//;\\n1;a;3"

        assertThrows<IllegalArgumentException> {
            CustomParser().parseBySeparator(testCommand)
        }
    }
}