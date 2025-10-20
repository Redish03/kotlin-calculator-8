package calculator.domain

class ParserClassifier {
    private val customParser: CustomParser = CustomParser()
    private val standardParser: StandardParser = StandardParser()

    fun create(command: String): Parser {
        if(command.startsWith(CUSTOM_PARSER_PREFIX)) {
            return customParser
        }
        return standardParser
    }

    companion object {
        const val CUSTOM_PARSER_PREFIX = "//"
    }
}