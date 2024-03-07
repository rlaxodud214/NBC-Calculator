package com.example.calculator.Operation

import com.example.calculator.controller.Calculator
import com.example.calculator.model.Formula

class MultiplyOperation(formula: Formula): Calculator(formula) {
    override fun calculate(): Int {
        return formula.run { multiply(numbers[0], numbers[1]) }
    }

    fun multiply(num1: Int, num2: Int) = num1 * num2
}