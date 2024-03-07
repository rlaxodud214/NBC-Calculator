package com.example.calculator.view

import com.example.calculator.model.Formula

class InputView {
    lateinit var inputData: String

    // TODO : 10라인 이하로 줄이기
    fun inputFormula(): Formula {
        // 한글 출력 오류 : 2개의 숫자와 1개의 연산자를 입력해주세요
        print("input Formula (ex. 100+2) : ")

        while (true) {
            inputData = readLine()!!

            if (inputData.isNullOrBlank()) {
                // 한글 출력 오류 : 올바르게 입력되지 않았습니다. 다시 입력해주세요
                println("It was not entered correctly. Please enter again")
                continue
            }

            break
        }

        return Formula(inputData)
    }
}