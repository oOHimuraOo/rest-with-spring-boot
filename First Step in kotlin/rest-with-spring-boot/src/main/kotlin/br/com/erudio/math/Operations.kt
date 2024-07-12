package br.com.erudio.math

import kotlin.math.sqrt

class Operations {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo

    fun sub(numberOne: Double, numberTwo: Double) = numberOne - numberTwo

    fun mut(numberOne: Double, numberTwo: Double) = numberOne * numberTwo

    fun divide(numberOne: Double, numberTwo: Double) = numberOne / numberTwo

    fun squareRoot(number: Double) = sqrt(number)

    fun mean(numbers: DoubleArray): Double {
        var sum = 0.0
        for (number in numbers) {
            sum += number
        }
        return sum / numbers.size
    }
}