package com.explorekotlin._9gettingfunctional

import java.util.*

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    println("String  is $this");
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()

}

fun transaction(s: String, code: (s1: String) -> Unit){
    code(s)
}

fun operation(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

fun unaryOperation(x: Int, op: (Int) -> Int) {

    val result = op(x)
    println("result : $result")
}


fun str(): String? = null

fun sum(x: Int, y: Int) = x + y

fun anonymousFunc(){

    unaryOperation(3, fun(x : Int) : Int {
        return x * x
    })
}


fun main() {

    println(operation(1, 2, ::sum))
    val sumLamda = { x: Int, y: Int -> x - y }

    println("Result is : ${operation(1, 2) { x, y -> x - y }}")

    unaryOperation(1, { x -> x * x })
    unaryOperation(1) {
            x -> x * x
    }

    transaction("Dilip"){
        val result = it.uppercase()
        println(result)
        println("MultiLine Lamda")
    }

    for (i in 1..5) {
        println("i is $i")
    }

    try {
        str()!!
    } catch (ex: Exception) {
        println("ex : $ex")
    }



    println("Status is ${"inactive".contains("active")}")
    println("Status is ${"LES_INACTIVE".lowercase(Locale.getDefault()).contains("active")}")

}