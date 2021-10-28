package com.explorekotlin._6Tidbits

import java.lang.Exception

class NotANumberException(override val message: String) : Throwable(message)

fun checkIsNumber(obj: Any) {
    when (obj) {
        !is Int, Float, Long -> throw NotANumberException("Not a Number")
    }
}

fun main() {

    try {
        checkIsNumber("A")
    } catch (ex: NotANumberException) {
        println("NotANumberException observed in ${ex.message}")
    } catch (ex: Exception) {
        println("Exception is $ex")
    }finally {
        println("Inside Finally Block")
    }


    val result = try {
        checkIsNumber("A")
    } catch (ex: NotANumberException) {
        println("NotANumberException observed in ${ex.message}")
    } catch (ex: Exception) {
        println("Exception is $ex")
    }finally {
        println("Inside Finally Block")
    }

    println("Result is $result")

}