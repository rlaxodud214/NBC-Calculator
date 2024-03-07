package com.example.calculator.controller

import com.example.calculator.model.Formula

class Calculator(val formula: Formula) {
    fun calculate(): Int {
        return when (formula.operator) {
            '+' -> formula.run { plus(numbers[0], numbers[1]) }
            '-' -> formula.run { minus(numbers[0], numbers[1]) }
            '*' -> formula.run { multiply(numbers[0], numbers[1]) }
            '/' -> formula.run { divide(numbers[0], numbers[1]) }
            else -> throw Exception("Error - operator not in operators")
        }
    }

    fun plus(num1: Int, num2: Int) = num1 + num2
    fun minus(num1: Int, num2: Int) = num1 - num2
    fun multiply(num1: Int, num2: Int) = num1 * num2
    fun divide(num1: Int, num2: Int) = num1 / num2
}