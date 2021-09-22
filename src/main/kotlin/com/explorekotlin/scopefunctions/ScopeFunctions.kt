package com.explorekotlin.scopefunctions

import kotlin.random.Random

class Also {
}

fun writeToLog(message: String) {
    println("INFO: $message")
}

fun also(name : String?=null): Int {
    return Random.nextInt(100).also { value ->
        writeToLog("getRandomInt() generated value $value and the name is")
    }
}

fun main() {



    val i = also("Dilip")
    println("Also result : $i")
}