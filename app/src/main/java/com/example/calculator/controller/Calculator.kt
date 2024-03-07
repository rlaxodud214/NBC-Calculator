package com.example.calculator.controller

import com.example.calculator.Operation.AbstractOperation
import com.example.calculator.Operation.AddOperation
import com.example.calculator.Operation.DivideOperation
import com.example.calculator.Operation.MultiplyOperation
import com.example.calculator.Operation.SubstractOperation
import com.example.calculator.model.Formula

open class Calculator(val formula: Formula): AbstractOperation() {
    override fun calculate(): Int {
        return when (formula.operator) {
            '+' -> AddOperation(formula)
            '-' -> SubstractOperation(formula)
            '*' -> MultiplyOperation(formula)
            '/' -> DivideOperation(formula)
            // '%' -> formula.run { remain(numbers[0], numbers[1]) }
            else -> throw Exception("Error - operator not in operators")
        }.calculate()
    }

    // fun remain(num1: Int, num2: Int) = num1 % num2

    companion object {
        var lastResultValue = ""
    }
}