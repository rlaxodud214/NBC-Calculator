package com.example.calculator.model

import com.example.calculator.controller.Calculator
import com.example.calculator.controller.Calculator.Companion.operators

/* Formula class에 대한 멘토님 피드백 반영 (이해한 대로 작성하여 다소 의역의 여지가 있음)

1. 아래와 같이 프로퍼티와 메소드를 가진 Formula class는 data class로 사용하는 게 kotlin 답다.

2. 그러면 검증관련 로직(메서드)를 data class에서 해도 괜찮을까요?
- 검증은 별도의 validate class에서 하거나 Formula의 확장함수로 빼기
- 이유 : validate라는 검증 메소드가 Formula class에 적합하지 않은 것 같아서

3. data class는 body 없이 작성하는 것이 컨벤션에 적합하다.

4. 팩토리 함수를 companion object 안에 위치 시키는 것은 class의 private 프로퍼티나 메서드에 접근하기 위함이다.

 */
data class Formula(
    var numbers: List<Double> = listOf<Double>(),
    var operator: Char = ' '
)

fun Formula.setValue(inputData: String): Formula {
    return this.apply {
        this.operator = setOperator(inputData)
        this.numbers = setNumbers(inputData)
    }
}

fun Formula.setValue(operator: String, number: String): Formula {
    val inputData = listOf(Calculator.lastResultValue, operator, number)
        .joinToString()

    val formula = this.apply {
        // 2. setNumbers와 setOperator를 호출해서 파라미터의 데이터를 넣어준다.
        this.operator = setOperator(inputData)
        this.numbers = setNumbers(inputData)
    }

    return formula
}

fun Formula.setOperator(inputData: String): Char {
    val operator = inputData.filter {
        it in operators
    }

    validateOperator(operator)

    return if (operator.count() == 1) operator[0] else 'e' // error
}

fun Formula.validateOperator(operator: String) {
    require(operator.count() == 1) {
        "The number of operators is not 1"
    }
}

fun Formula.setNumbers(inputData: String): List<Double> {
    val numData = inputData.split(operator).map {
        it.trim().toDouble()
    }

    validateNumbers(numData)

    return numData
}

fun Formula.validateNumbers(numData: List<Double>) {
    require(numData.count() == 2) {
        "not two number"
    }

    require(numData.all { it is Double }) {
        "not number"
    }
}

