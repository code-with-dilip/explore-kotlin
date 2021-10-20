package com.explorekotlin.functions

import com.explorekotlin.higher_order_functions.sum

fun printSomething() : Unit{
    println("printSomething")
}

fun nothing() : Nothing{
    throw RuntimeException("Exception Occurred")
}

fun multiply(x : Int , y : Int): Int {
    return x*y
}

fun multiply1(x : Int , y : Int) = x*y

fun multiply2(x : Int , y : Int): Int {
    println("x : $x and y : $y")
    return x*y
}


fun main() {

    printSomething()
    sum(2,3)
    multiply(2,3)

}