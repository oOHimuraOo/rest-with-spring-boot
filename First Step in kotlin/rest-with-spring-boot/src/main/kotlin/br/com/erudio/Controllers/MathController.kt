package br.com.erudio.Controllers

import br.com.erudio.math.Operations
import br.com.erudio.exceptions.UnsupportedMathOperationException
import br.com.erudio.validations.MathValidations
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    private val math: Operations = Operations()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!MathValidations.isNumeric(numberOne) || !MathValidations.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please provide a numeric value!")
        }
        return math.sum(MathValidations.convertToDouble(numberOne),MathValidations.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!MathValidations.isNumeric(numberOne) || !MathValidations.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please provide a numeric value!")
        }
        return math.sub(MathValidations.convertToDouble(numberOne), MathValidations.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/mut/{numberOne}/{numberTwo}"])
    fun mut(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!MathValidations.isNumeric(numberOne) || !MathValidations.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please provide a numeric value!")
        }
        return math.mut(MathValidations.convertToDouble(numberOne), MathValidations.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/divide/{numberOne}/{numberTwo}"])
    fun divide(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!MathValidations.isNumeric(numberOne) || !MathValidations.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please provide a numeric value!")
        }
        return math.divide(MathValidations.convertToDouble(numberOne), MathValidations.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/med/{numbers:.*}"])
    fun med(@PathVariable(value = "numbers") numbers: String?): Double {
        val numberList = numbers?.split("|")?.map { it.trim() } ?: emptyList()
        if (numberList.size < 2) {
            throw UnsupportedMathOperationException("Please provide at least two numeric values!")
        }
        if (numberList.any { !MathValidations.isNumeric(it) }) {
            throw UnsupportedMathOperationException("Please provide numeric values!")
        }
        val numbersArray = numberList.map { MathValidations.convertToDouble(it) }.toDoubleArray()
        return math.mean(numbersArray)
    }

    @RequestMapping(value = ["/sqrt/{numberOne}"])
    fun sqrt(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!MathValidations.isNumeric(numberOne)) {
            throw UnsupportedMathOperationException("Please provide a numeric value!")
        }
        return math.squareRoot(MathValidations.convertToDouble(numberOne))
    }
}