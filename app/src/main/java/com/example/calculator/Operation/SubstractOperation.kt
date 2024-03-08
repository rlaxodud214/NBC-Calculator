package com.example.calculator.Operation

import com.example.calculator.model.Formula

class SubstractOperation() : Operation() {
    override fun operate(formula: Formula): Double {
        return formula.run { minus(numbers[0], numbers[1]) }
    }

    fun minus(num1: Double, num2: Double) = num1 - num2
}