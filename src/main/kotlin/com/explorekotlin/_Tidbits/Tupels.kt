package com.explorekotlin._Tidbits

fun nameAndLength(name: String): Pair<String, Int> {
    return Pair(name, name.length)
}

fun nameAndLengthAndAge(name: String, age: Int): Triple<String, Int, Int> {
    return Triple(name, name.length, age)
}


fun main() {

    val namePair = nameAndLength("Dilip")
    println("${namePair.first} and ${namePair.second}")

    val nameTriple = nameAndLengthAndAge("Dilip", 33)
    println("${nameTriple.first} and ${nameTriple.second} and the age is ${nameTriple.third}")

}