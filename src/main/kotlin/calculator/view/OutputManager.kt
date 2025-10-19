package calculator.view

class OutputManager {
    fun printGuide(){
        print("덧셈할 문자열을 입력해 주세요.")
    }

    fun printResult(result: Int) {
        print("결과 : $result")
    }
}