package calculator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ParserClassifierTest {
    @Test
    fun `커스텀 구분자를 사용하는지 확인한다`() {
        // given
        val command = "//;\\n1"

        // when
        val parser = ParserClassifier().create(command)

        // then
        assertTrue(parser is CustomParser)
    }

    @Test
    fun `기본 구분자를 사용하는지 확인한다`() {
        // given
        val command = "1,2:3"

        // when
        val parser = ParserClassifier().create(command)

        // then
        assertTrue(parser is StandardParser)
    }
}