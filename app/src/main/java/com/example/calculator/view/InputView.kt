package com.example.calculator.view

import com.example.calculator.model.Formula

class InputView {
    lateinit var inputData: String

    // TODO: 한글 출력 오류로 인해 inputPrompt는 모두 영어로 작성했습니다.
    fun inputFormula(prompt: String): String {
        print(prompt)

        do {
            inputData = readLine()!!
            val isEmpty = inputData.isNullOrBlank()

            if (isEmpty) {
                println("[Error] : It was not entered correctly. Please enter again")
            }
        } while (isEmpty)

        return inputData
    }
}