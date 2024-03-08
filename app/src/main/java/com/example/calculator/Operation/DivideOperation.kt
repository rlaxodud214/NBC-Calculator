package com.example.calculator.Operation

import com.example.calculator.model.Formula

class DivideOperation() : Operation() {
    override fun operate(formula: Formula): Double {
        return formula.run { divide(numbers[0], numbers[1]) }
    }

    fun divide(num1: Double, num2: Double): Double {
        require(num2 != 0.0) {
            "It cannot be divided by 0."
        }

        return num1 / num2
    }
}