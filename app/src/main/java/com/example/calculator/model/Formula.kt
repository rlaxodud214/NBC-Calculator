package com.example.calculator.model

class Formula(_inputData: String) {
    var numbers = listOf<Int>()
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
            println("not operator")
        }

        return if(operator.count() == 1) operator[0] else 'e' // error
    }

    fun validateNumberCount(inputData: String): List<Int> {
        val numData = inputData.split(operator).map {
            it.replace(" ", "").toInt()
        }

        require(numData.count() == 2) { println("not two number") }
        require(numData.all { it is Int }) { println("not Int") }

        return numData!!
    }

    companion object {
        val operators = listOf('+', '-', '*', '/')
    }
}