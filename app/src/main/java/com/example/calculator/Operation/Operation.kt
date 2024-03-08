package com.example.calculator.Operation

import com.example.calculator.model.Formula

abstract class Operation {
    // 기존에 아래 메서드의 이름은 calculator의 역할이여야 한다. 그리고,
    // calculator의 calculate 메서드와 이름이 같아 혼동이 있을 수 있으니 operate로 명명
    abstract fun operate(formula: Formula): Double
}