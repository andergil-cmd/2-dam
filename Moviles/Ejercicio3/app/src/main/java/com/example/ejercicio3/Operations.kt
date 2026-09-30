package com.example.ejercicio3

class Operations {
    fun doOperation(operation: String?): String? {
        if (operation == null) return null
        var ret: String? = ""
        var firstNumber = ""
        var lastNumber = ""
        if (isAddition(operation)) {
            firstNumber = operation.substring(0, operation.indexOf(" + "))
            lastNumber = operation.substring(operation.indexOf(" + ") + 3)
            ret = "" + add(
                firstNumber.trim { it <= ' ' }.toInt(),
                lastNumber.trim { it <= ' ' }.toInt()
            )
        } else if (isSubtraction(operation)) {
            firstNumber = operation.substring(0, operation.lastIndexOf("-"))
            lastNumber = operation.substring(operation.lastIndexOf("-") + 1)
            ret = "" + substract(firstNumber.trim { it <= ' ' }.toInt(),
                lastNumber.trim { it <= ' ' }.toInt()
            )
        }
        return ret
    }



    private fun isAddition(operation: String): Boolean {
        var ret = false
        val countAdd = operation.length - operation.replace("+", "").length
        val countSubs = operation.length - operation.replace("-", "").length
        if (countAdd == 1 && countSubs == 0) ret = true
        return ret
    }

    private fun isSubtraction(operation: String): Boolean {
        var ret = false
        val countAdd = operation.length - operation.replace("-", "").length
        val countSubs = operation.length - operation.replace("+", "").length
        if (countAdd == 1 && countSubs == 0) ret = true
        return ret
    }

    private fun add(op1: Int, op2: Int): Int {
        return op1 + op2
    }

    private fun substract(op1: Int, op2: Int): Int {
        return op1 - op2
    }
}