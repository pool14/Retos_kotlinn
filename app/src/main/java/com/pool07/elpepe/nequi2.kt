package com.pool07.elpepe

class Nequi2 {
    var saldoDisponible: Double = 4500.0

    fun acceder(celular: String, clave: String) {
        var intentos = 3

        while (intentos > 0) {
            println("Ingrese su número de celular:")
            val celularInput: String = readLine()!!
            println("Ingrese su clave de 4 dígitos:")
            val claveInput: String = readLine()!!

            if (celularInput == celular && claveInput == clave) {
                println("¡Bienvenido a Nequi!")
                return // Exit the function as the user is successfully authenticated.
            } else {
                intentos--
                if (intentos > 0) {
                    println("¡Upps! Parece que tus datos de acceso no son correctos. Tienes $intentos intentos más.")
                } else {
                    println("¡Upps! Parece que tus datos de acceso no son correctos. Has agotado tus intentos.")
                }
            }
        }
    }

    fun mostrarSaldo() {
        println("Tu saldo disponible es: $saldoDisponible")
    }

    fun sacar() {
        println("Elige una opción para sacar dinero:")
        println("1. Cajero")
        println("2. Punto físico")
        val opcion: Int = readLine()!!.toInt()

        if (saldoDisponible < 2000) {
            println("No te alcanza para hacer el retiro.")
        } else {
            println("Ingrese el monto a retirar:")
            val monto: Int = readLine()!!.toInt()

            if (monto <= saldoDisponible && monto>0) {
                println("Para confirmar el retiro de $monto oprima 1:")
                val confirmacion: Int = readLine()!!.toInt()

                if (confirmacion == 1) {
                    saldoDisponible -= monto
                    val codigoRetiro = (100000..999999).random()
                    println("Retiro exitoso. Código de retiro: $codigoRetiro")
                } else {
                    println("Retiro cancelado.")
                }
            } else {
                println("Saldo insuficiente para realizar el retiro.")
            }
        }
    }

    fun enviar() {
        println("Ingrese el número de teléfono al que desea enviar dinero:")
        val numeroTelefono: String = readLine()!!

        println("Ingrese el valor a enviar:")
        val valorEnviar: Double = readLine()!!.toDouble()

        if (valorEnviar <= saldoDisponible) {
            saldoDisponible = saldoDisponible - valorEnviar
            println("Envío de dinero exitoso a $numeroTelefono por valor de $valorEnviar")
        } else {
            println("No es posible enviar el dinero. Saldo insuficiente.")
        }
    }

    fun recargar() {
        println("Ingrese el valor a recargar:")
        val valorRecarga: Double = readLine()!!.toDouble()

        println("¿Desea realizar la recarga por valor de $valorRecarga? (si/no)")
        val confirmacion: String = readLine()!!

        if (confirmacion == "si") {
            saldoDisponible += valorRecarga
            println("Recarga exitosa. Nuevo saldo: $saldoDisponible")
        } else {
            println("Recarga cancelada.")
        }
    }
}

fun main() {
    val nequi = Nequi2()
    val celular = "3222431912"
    val clave = "1234"
    nequi.acceder(celular, clave)

    var continuar = true

    while (continuar) {
        println("¿Qué acción desea realizar?")
        println("1. Mostrar saldo")
        println("2. Sacar dinero")
        println("3. Enviar dinero")
        println("4. Recargar")
        println("5. Salir")

        val opcion: Int = readLine()!!.toInt()

        when (opcion) {
            1 -> nequi.mostrarSaldo()
            2 -> nequi.sacar()
            3 -> nequi.enviar()
            4 -> nequi.recargar()
            5 -> {
                println("Saliendo de Nequi...")
                continuar = false
            }
            else -> println("Opción inválida. Intente de nuevo.")
        }
    }
}
