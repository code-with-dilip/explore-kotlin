package com.kotlinplayground.collections




fun main() {

    val names = listOf("Alex", "Ben", "Chloe")
    println("names : $names")
    val namesMutableList = mutableListOf("Alex", "Ben", "Chloe")

    namesMutableList.add("Adam")
    println("namesMutableList : $namesMutableList")


    val nameAgeMap = hashMapOf("dilip" to  33 ,"scooby"  to  4)
    println("nameAgeMap : $nameAgeMap")

    val nameAgeMutableMap = mutableMapOf("dilip" to  33 ,"scooby"  to  4)
    nameAgeMutableMap.put("abc", 100)
    println("nameAgeMutableMap : $nameAgeMutableMap")

    val set = setOf("adam", "ben", "chloe")
    println("set: $set")

    val mutableSet = mutableSetOf("adam", "ben", "chloe")
    mutableSet.add("adam1")
    println("mutableSet :  $mutableSet" )



}