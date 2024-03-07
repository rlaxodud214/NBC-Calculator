package com.example.calculator

import com.example.calculator.controller.Calculator
import com.example.calculator.view.InputView

fun main() {
    System.setProperty("file.encoding", "UTF-8")

    val inputView = InputView()
    val formula = inputView.inputFormula()

    val cal = Calculator(formula)
    println("result: ${cal.calculate()}")
}