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

    fun addInput(): Formula? {
        val inputType = input("Please enter a value between 1 and 5 to continue calculating, or -1 to stop. \n"
                + "The numbers 1 to 4 stand for +, -, *, and /, respectively : ")

        if (inputType == "-1") {
            Process.inputState = InputState.DONE
            return null
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