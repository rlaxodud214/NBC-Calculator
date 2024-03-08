package com.example.calculator.controller

import com.example.calculator.InputState
import com.example.calculator.model.Formula
import com.example.calculator.view.InputView

class Input(val inputView: InputView) {

    fun input(prompt: String) = inputView.inputFormula(prompt)

    fun firstInput(): Formula {
        val inputData = input("Input Formula (ex. 100+2) : ")
        Process.inputState = InputState.KEEP

        return Formula(inputData)
    }

    fun addInput(): Formula? {
        println("\nNext, we proceed with the calculation.")
        val inputType = input("input Operator (ex. +, -, *, /), -1 is stop, r is reset : ")

        isReset(inputType)
        val exit = isExit(inputType)
        val notOperator = isNotOperator(inputType)

        if(exit == true || notOperator == true) {
            return null
        }
        val inputNumber = input("input Value : ")

        return Formula.create(inputType, inputNumber)
    }

    fun isReset(ch: String) {
        if (ch == "r") {
            Calculator.lastResultValue = "0"
            println("Reset is complete. Current result is ${Calculator.lastResultValue}")
        }
    }

    fun isExit(ch: String): Boolean {
        return if (ch == "-1") {
            Process.inputState = InputState.DONE
            true
        } else false
    }

    fun isNotOperator(ch: String): Boolean {
        val condition = ch.trim()[0] !in Formula.operators

        if(ch.trim()[0] != 'r' && condition) {
            println("[Error] : It is not the correct number. retry")
        }

        return condition
    }
}