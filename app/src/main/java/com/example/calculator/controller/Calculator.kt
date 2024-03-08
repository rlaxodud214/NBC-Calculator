package com.example.calculator.controller

import com.example.calculator.Operation.AddOperation
import com.example.calculator.Operation.DivideOperation
import com.example.calculator.Operation.MultiplyOperation
import com.example.calculator.Operation.SubstractOperation
import com.example.calculator.model.Formula

class Calculator() {
    fun calculate(formula: Formula): Double {
        return when (formula.operator) {
            '+' -> AddOperation()
            '-' -> SubstractOperation()
            '*' -> MultiplyOperation()
            '/' -> DivideOperation()
            else -> throw Exception("[Error] : operator not in operators")
        }.operate(formula)
    }

    companion object {
        var lastResultValue = ""
    }
}