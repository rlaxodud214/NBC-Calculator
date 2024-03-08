package com.example.calculator.Operation

import com.example.calculator.model.Formula

abstract class AbstractOperation {
    abstract fun calculate(formula: Formula): Double
}