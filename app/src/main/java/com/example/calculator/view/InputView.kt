package com.example.calculator.view

import com.example.calculator.model.Formula

class InputView {
    lateinit var inputData: String

    fun inputFormula(prompt: String): String {
        print(prompt) // 한글 출력 오류 : 2개의 숫자와 1개의 연산자를 입력해주세요

        do {
            inputData = readLine()!!

            if(inputData.isNullOrBlank()) {
                println("It was not entered correctly. Please enter again")
            }
        } while (inputData.isEmpty())

        return inputData
    }
}