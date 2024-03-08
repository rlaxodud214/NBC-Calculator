package com.example.calculator.model

import com.example.calculator.controller.Calculator
import com.example.calculator.controller.Process

class Formula(_inputData: String) {
    var numbers = listOf<Double>()
    var operator: Char

    init {
        operator = validateOperator(_inputData)
        numbers = validateNumberCount(_inputData)
    }

    fun validateOperator(inputData: String): Char {
        val operator = inputData.filter {
            it in operators
        }

        require(operator.count() == 1) {
            "The number of operators is not 1"
        }

        return if (operator.count() == 1) operator[0] else 'e' // error
    }

    fun validateNumberCount(inputData: String): List<Double> {
        // 100 + 12 1 입력 시, 아래 replace 때문에 100 + 121으로 처리되는 이슈
        val numData = inputData.split(operator).map {
            it.trim().toDouble()
        }

        require(numData.count() == 2) { "not two number" }
        require(numData.all { it is Double }) { "not number" }

        return numData
    }

    companion object {
        val operators = listOf('+', '-', '*', '/')

        fun create(operator: String, number: String): Formula {
            val inputData = listOf(Calculator.lastResultValue, operator, number)
            return Formula(inputData.joinToString(" "))
        }
    }
}