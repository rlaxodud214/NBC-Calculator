package com.example.calculator

import com.example.calculator.controller.Process
import com.example.calculator.view.InputView
import java.lang.Exception
import java.lang.NumberFormatException


fun main() {
    val inputView = InputView()
    val processController = Process(inputView)

    try {
        processController.run()
    } catch (e: NumberFormatException) {
        e.message?.let { println("[Error] Cannot be converted to number.") }
    } catch (e: Exception) {
        e.message?.let { println("[Error] " + it) }
    }
}