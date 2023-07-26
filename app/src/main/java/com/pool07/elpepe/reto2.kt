package com.pool07.elpepe

import kotlin.random.Random

class reto2 {
}

fun main() {
        println("Realiza una compra mayor a $50.000 para participar en nuestro sorteo.")
        print("¿Cuántos productos deseas ingresar?: ")
        val num: Int = readLine()!!.toInt()

        var descuento: Double
        var contador = 0
        var contador1 = 0
        var total = 0
        var total1 = 0

        for (contador2 in 1..num) {
            print("Ingresa el precio del producto: ")
            val precio: Int = readLine()!!.toInt()

            if (precio > 50000) {
                println("¡Has ingresado al sorteo!")
                total += precio
            }

            when (Random.nextInt(1, 5)) {
                1 -> {
                    println("Has sacado una bola amarilla. Obtendrás un 50% de descuento.")
                    descuento = 0.5
                }
                2 -> {
                    println("Has sacado una bola roja. Obtendrás un 10% de descuento.")
                    descuento = 0.1
                }
                3 -> {
                    println("Has sacado una bola azul. Obtendrás un 30% de descuento.")
                    descuento = 0.3
                }
                else -> {
                    println("Has sacado una bola blanca. ¡Tu compra es GRATIS!")
                    descuento = 1.0
                }
            }

            val precioConDescuento = precio - (precio * descuento).toInt()
            if (precioConDescuento % 2 == 0) {
                contador++
                total1 += precioConDescuento
            } else {
                contador1++
                total1 += precioConDescuento
            }
        }

        println("El número de precios pares ingresados es $contador y el número de precios impares ingresados es $contador1")
        println("La suma de los precios pares con descuento es $total y la suma de los precios impares con descuento es $total1")
    }

