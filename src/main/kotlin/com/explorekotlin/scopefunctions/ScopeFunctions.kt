package com.explorekotlin.scopefunctions

import kotlin.random.Random

class Also {
}

fun writeToLog(message: String) {
    println("INFO: $message")
}

fun also(): Int {
    return Random.nextInt(100).also {
        writeToLog("getRandomInt() generated value $it")
    }
}

fun main() {



    val i = also()
    println("Also result : $i")
}