package com.example.calculator.controller

import com.example.calculator.InputState
import com.example.calculator.controller.Calculator.Companion
import com.example.calculator.view.InputView

class Process(val inputView: InputView) {
    val inputController = Input(inputView)

    fun run() {
        while (true) {
            val formula = when (inputState) {
                InputState.FIRST -> inputController.firstInput()
                InputState.KEEP -> inputController.addInput()
                else -> break
            }

            // 입력 상태가 DONE 일 때만 null을 반환하므로 아래에서 formula!! 사용
            if(inputState == InputState.DONE) {
                println("final Result: ${Calculator.lastResultValue}")
                break
            }

            val cal = Calculator(formula!!)
            Calculator.lastResultValue = cal.calculate().toString()
            println("result: ${Calculator.lastResultValue}")
        }
    }

    companion object {
        var inputState = InputState.FIRST
    }
}