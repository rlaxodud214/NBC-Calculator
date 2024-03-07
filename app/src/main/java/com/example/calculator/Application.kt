package com.example.calculator

import com.example.calculator.controller.Process
import com.example.calculator.view.InputView
import java.lang.Exception


fun main() {
    val inputView = InputView()
    val processController = Process(inputView)

    try {
        processController.run()
    } catch (e: Exception) {
        e.message?.let { println("[Error] " + it) }
    }
}