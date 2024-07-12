package br.com.erudio.validations

import br.com.erudio.exceptions.UnsupportedMathOperationException

class MathValidations {
    companion object{
        fun convertToDouble(strNumber: String?): Double {
            if (strNumber.isNullOrBlank()){
                return 0.0
            }
            val number = strNumber.replace(",".toRegex(),".")
            if (isNumeric(number)){
                return number.toDouble()
            }
            else {
                throw UnsupportedMathOperationException("Please provide a numeric value!")
            }
        }

        fun isNumeric(strNumber: String?): Boolean {
            if (strNumber.isNullOrBlank()) {
                return false
            }
            val number = strNumber.replace(",".toRegex(),".")
            return number.matches("[-+]?[0-9]*\\.?[0-9]+".toRegex())
        }
    }

}