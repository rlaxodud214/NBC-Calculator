package com.example.calculator.Operation

import com.example.calculator.controller.Calculator
import com.example.calculator.model.Formula

class SubstractOperation(val formula: Formula): AbstractOperation() {
    override fun calculate(): Int {
        return formula.run { minus(numbers[0], numbers[1]) }
    }

    fun minus(num1: Int, num2: Int) = num1 - num2
}