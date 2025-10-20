package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StandardParserTest {
    @Test
    fun `쉼표와 쌍점으로 문자열을 구분한다`() {
        // given: 테스트로 주어질 문자열과 정답 리스트 설정
        val testCommand = "1,2:3"
        val successedParse = listOf<Int>(1, 2, 3)

        // when: 함수 실행
        val result = StandardParser().parseBySeparator(testCommand)

        // then: 실행결과와 정답리스트가 같은지 확인
        assertEquals(result, successedParse)
    }

    @Test
    fun `주어진 명령어에 빈칸과 숫자가 섞여있다면 IllegalArgumentException을 발생시킨다` () {
        val testCommand = "1,:3"

        assertThrows<IllegalArgumentException> {
            CustomParser().parseBySeparator(testCommand)
        }
    }

    @Test
    fun `주어진 명령어에 숫자가 아닌 값이 있다면 IllegalArgumentException을 발생시킨다` () {
        val testCommand = "1;a;3"

        assertThrows<IllegalArgumentException> {
            CustomParser().parseBySeparator(testCommand)
        }
    }
}