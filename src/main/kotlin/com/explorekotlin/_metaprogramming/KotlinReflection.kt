package com.explorekotlin._metaprogramming

import kotlin.reflect.full.memberProperties

fun main() {
    println(Transaction::class)
    val classInfo = Transaction::class
    classInfo.memberProperties
        .forEach {
            println("Name ${it.name} of type ${it.returnType}")
        }


    val constructor = ::Transaction
    val transaction = constructor.call(1, 2000.0, "20000")

    val transaction1 = constructor.callBy(mapOf(constructor.parameters[0] to 2,constructor.parameters[1] to 2000.0, constructor.parameters[2] to "20000"))

    val id = constructor.parameters.first { it.name == "id" }
    val amount = constructor.parameters.first { it.name == "amount" }
    val transaction2 = constructor.callBy(mapOf(id to 2,amount to 2000.0, constructor.parameters[2] to "20000"))


    println("transaction : ${transaction.id}")
    println("transaction1 : ${transaction1.id}")
    println("transaction2 : ${transaction2.id}")
}