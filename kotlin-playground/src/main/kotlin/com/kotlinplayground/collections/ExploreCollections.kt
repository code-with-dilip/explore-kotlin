package com.kotlinplayground.collections




fun main() {

    val names = listOf("Alex", "Ben", "Chloe")

    val namesMutableList = mutableListOf("Alex", "Ben", "Chloe")

    namesMutableList.add("Adam")


    val nameAgeMap = hashMapOf("dilip" to  33 ,"scooby"  to  4)
    println(nameAgeMap)

    val nameAgeMutableMap = mutableMapOf("dilip" to  33 ,"scooby"  to  4)
    nameAgeMutableMap.put("abc", 100)
    println(nameAgeMutableMap)

    val set = setOf("adam", "ben", "chloe")
    println(set)

    val mutableSet = mutableSetOf("adam", "ben", "chloe")
    println(mutableSet)

}