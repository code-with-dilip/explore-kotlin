package com.explorekotlin.coroutines

import kotlinx.coroutines.*
import java.io.IOException
import java.net.SocketTimeoutException

class ExploreCoroutines {


}

fun main() {

    runBlocking {
        //var result : String? = null
        val result = invokeMultipleCoroutines()
        try {

        }catch (ex: Exception){

        }

        println("Result is : $result")
    }

    val ex = SocketTimeoutException("Exception Occurred")

    println("Is IllegalAccessException : ${ex is IllegalAccessException}")
    println("Is IO Exception : ${ex is IOException}")

}

//suspend fun invokeMultipleCoroutines() = coroutineScope {

fun invokeMultipleCoroutines() : String?{

/*    val first  = async {
            firstCoroutine()
        }

    val second  =async {
        secondCoroutine()
    }*/

    return try {

        throw RuntimeException("Exception Occurred")

    }
    catch (ex: CancellationException){
        ex.printStackTrace()
        println("CancellationException Occurred : $ex")
        null
    }
    catch (ex: Exception){
        ex.printStackTrace()
        println("Exception Occurred : $ex")
        null
    }

}

suspend fun secondCoroutine(): Any {

    delay(500)
    throw RuntimeException("Exception Occurred")

}

suspend fun firstCoroutine(): String {

    delay(1500)
    return "Dilip"
}
