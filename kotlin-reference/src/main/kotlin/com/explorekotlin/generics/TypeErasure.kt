package com.explorekotlin.generics


fun checkType(input : Collection<*>) {

        val list = input as? List<Int> ?:
        throw IllegalArgumentException("Exception")

        println("Sum is ${list.sum()}")

}


fun main() {
    val stringList = listOf("abc", "def")

    val intList = listOf(1, 2)
    val intSet = setOf(1, 2)

    checkType(intList)
    checkType(stringList)
    checkType(intSet)
}