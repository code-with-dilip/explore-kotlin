package com.explorekotlin._Tidbits

import com.explorekotlin._3classes.CustomerData

fun nameAndLength(name: String): Pair<String, Int> {
    return Pair(name, name.length)
}

fun nameAndLengthAndAge(name: String, age: Int): Triple<String, Int, Int> {
    return Triple(name, name.length, age)
}


fun main() {

    val namePair = nameAndLength("Dilip")
    println("${namePair.first} and ${namePair.second}")

    val (name, length) = namePair
    println("$name and $length")

    val nameTriple = nameAndLengthAndAge("Dilip", 33)
    println("${nameTriple.first} and ${nameTriple.second} and the age is ${nameTriple.third}")

    val (name1, length1, age) = nameTriple
    println("$name1 and $name1 and age" )

    val customer = CustomerData(1, "Dilip", yearOfBirth = 1987)
    val (id, name2,email,yob ) = customer
    println("$id and $name2 and $yob" )

    val pairsList = listOf(nameAndLength("Dilip"), nameAndLength("Scooby"))

    for ((name, length) in pairsList){
        println("$name and $length")
    }

}