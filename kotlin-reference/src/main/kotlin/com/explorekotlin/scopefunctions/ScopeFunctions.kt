package com.explorekotlin.scopefunctions

import kotlin.random.Random

class Also {
}

fun writeToLog(message: String) {
    println("INFO: $message")
}

fun also(name : String?=null): Int {
    return Random.nextInt(100).also { value ->
        println("Value is : $value")
        writeToLog("getRandomInt() generated value $value and the name is $name")

    }
}


fun apply(name : String?=null): Int {
    return Random.nextInt(100)
        .apply {
            writeToLog("getRandomInt() generated value $this and the name is $name")
        }

}


fun main() {

    val also = also("Dilip")
    println("Also result : $also")

    val apply = apply("Dilip")
    println("apply result : $apply")
}