package com.example.calculator.Operation

import com.example.calculator.model.Formula

class AddOperation() : Operation() {
    override fun operate(formula: Formula): Double {
        return formula.run { plus(numbers[0], numbers[1]) }
    }

    fun plus(num1: Double, num2: Double) = num1 + num2
}