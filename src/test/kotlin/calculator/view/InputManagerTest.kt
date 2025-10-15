package calculator.view

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class InputManagerTest {
    @Test
    fun `입력한 값이 String 형인지 확인한다`(){
        // given: 가짜 입력 데이터 준비
        val fakeInput = "hello world!"
        val inputStream = ByteArrayInputStream(fakeInput.toByteArray())
        System.setIn(inputStream)

        // when: 함수 실행
        val result = InputManager.inputFromUser()

        // then: 반환값 검증
        assertTrue(result is String)
    }
}