package com.explorekotlin._9gettingfunctional

fun outsideFun(){
    val number = 10
    unaryOperation(10) {
        println(number+1)
        val number1 = number+1
        it * number1
    }
}

fun main() {

    outsideFun()

}