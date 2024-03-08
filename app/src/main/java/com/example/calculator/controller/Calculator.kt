package com.example.calculator.controller

import com.example.calculator.Operation.AbstractOperation
import com.example.calculator.Operation.AddOperation
import com.example.calculator.Operation.DivideOperation
import com.example.calculator.Operation.MultiplyOperation
import com.example.calculator.Operation.SubstractOperation
import com.example.calculator.model.Formula

open class Calculator() : AbstractOperation() {
    override fun calculate(formula: Formula): Double {
        return when (formula.operator) {
            '+' -> AddOperation()
            '-' -> SubstractOperation()
            '*' -> MultiplyOperation()
            '/' -> DivideOperation()
            else -> throw Exception("[Error] : operator not in operators")
        }.calculate(formula)
    }

    companion object {
        var lastResultValue = ""
    }
}