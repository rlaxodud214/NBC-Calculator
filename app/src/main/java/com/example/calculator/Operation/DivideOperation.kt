package com.example.calculator.Operation

import com.example.calculator.controller.Calculator
import com.example.calculator.model.Formula

class DivideOperation(formula: Formula): Calculator(formula) {
    override fun calculate(): Int {
        return formula.run { divide(numbers[0], numbers[1]) }
    }

    fun divide(num1: Int, num2: Int): Int {
        require(num2 == 0) {
            "It cannot be divided by 0."
        }

        return num1 / num2
    }
}