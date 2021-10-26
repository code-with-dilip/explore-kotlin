package com.explorekotlin._5nulls

fun main() {
    val name : String = "Dilip"
    println(name.length)

    var name1 : String? = null
    println(name1?.length)
    //println(name1!!.length)
    name1 = "abc"
    println(name1.length)
    val result = upperCase(null)
    println("result : $result")
}

fun upperCase(name : String?)  : String?{
    return name?.uppercase()
}