package com.example.calculator.Operation

import com.example.calculator.controller.Calculator
import com.example.calculator.model.Formula

class MultiplyOperation() : AbstractOperation() {
    override fun calculate(formula: Formula): Double {
        return formula.run { multiply(numbers[0], numbers[1]) }
    }

    fun multiply(num1: Double, num2: Double) = num1 * num2
}