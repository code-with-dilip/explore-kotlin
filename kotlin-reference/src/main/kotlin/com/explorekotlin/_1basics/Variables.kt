package com.explorekotlin._1basics

fun main() {

    var age: Int
    var name = "Dilip"

    val city = "Minneapolis"
//    city = "Detroit"

    val doorNo = 1500 // This always maps to integer by default
    val doorNoLong : Long = doorNo.toLong()

    val char = 'A'
    val str = "ABC"

    val escChar = "ABC \n DEF"

    val multiLine = "ABC\n" +
            "DEF\n" +
            "GHI\n"

    val multiLine1 =
"""
ABC
DEF
GHI
"""

    val message = "My name is $name"

    val message1 = "My name is $name and the name length is ${name.length}"

    println(multiLine)
    println(multiLine1)
    println(message)
}