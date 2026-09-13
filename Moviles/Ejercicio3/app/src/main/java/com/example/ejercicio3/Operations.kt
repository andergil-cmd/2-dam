package com.example.ejercicio3

class Operations {
    fun doOperation(operation: String): String{
        val partes =  operation.trim().split(" ")

        var resultado: String

        if(partes.size != 3){
            throw Exception("Operacion incorrecta")
        }

        val numero1 = partes[0].toInt()
        val operador = partes[1]
        val numero2 = partes[2].toInt()

        if(operador == "+"){
            resultado = (numero1 + numero2).toString()
        }else if(operador == "-"){
            resultado = (numero1 - numero2).toString()
        }else{
            throw Exception("Operador incorrecto")
        }

        return resultado
    }
}