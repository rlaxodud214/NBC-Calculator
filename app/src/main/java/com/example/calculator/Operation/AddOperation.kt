package com.example.calculator.Operation

import com.example.calculator.controller.Calculator
import com.example.calculator.model.Formula

class AddOperation(val formula: Formula): AbstractOperation() {
    override fun calculate(): Int {
        return formula.run { plus(numbers[0], numbers[1]) }
    }

    fun plus(num1: Int, num2: Int) = num1 + num2
}