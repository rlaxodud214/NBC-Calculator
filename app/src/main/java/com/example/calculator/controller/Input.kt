package com.example.calculator.controller

import com.example.calculator.InputState
import com.example.calculator.model.Formula
import com.example.calculator.view.InputView
import java.net.PasswordAuthentication

class Input(val inputView: InputView) {

    fun input(prompt: String) = inputView.inputFormula(prompt)

    fun firstInput(): Formula {
        val inputData = input("Input Formula (ex. 100+2) : ")
        Process.inputState = InputState.KEEP

        return Formula(inputData)
    }

    fun addInput(): Formula {
        val inputType = input("Please enter a value between 1 and 5 to continue calculating, or -1 to stop. \n"
                + "The numbers 1 to 4 stand for +, -, *, and /, respectively : ")

        // TODO : Formula(PASS) 리턴 안하고, Process의 while문에서 break 하도록 수정하기
        if (inputType == "-1") {
            Process.inputState = InputState.DONE
            return Formula(PASS)
        }

        require(inputType in "1".."4") {
            "It is not the correct number."
        }

        val inputNumber = input("Please enter a value : ")

        return Formula.create(inputType, inputNumber)
    }

    companion object {
        const val PASS = "100+2"
    }
}