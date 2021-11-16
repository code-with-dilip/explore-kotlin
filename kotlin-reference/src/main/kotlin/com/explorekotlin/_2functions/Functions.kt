package com.explorekotlin._2functions

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

fun multiply2(x : Int , y : Int, z: Int = 1, w : Int): Int {
    println("x : $x and y : $y")
    return x*y*z
}

fun personDetails(firstName: String, lastName : String, age: Int, city: String){
    println("firstName : $firstName, lastName : $lastName, age: $age , city: $city")
}

fun printMultipleThings(vararg strings: String){
    printVarargs(*strings)
}

private fun printVarargs(vararg strings: String) {
    for (string in strings) {
        println("String : $string")
    }
}


fun main() {

    printSomething()
    sum(2,3)
    multiply(2,3 )
    multiply2(2,3, w = 3)
    printMultipleThings("A", "B","C", "D")

}