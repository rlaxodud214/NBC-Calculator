package com.example.calculator

import com.example.calculator.controller.Process
import com.example.calculator.view.InputView


fun main() {
    val inputView = InputView()
    val processController = Process(inputView)

    processController.run()
}