package com.explorekotlin._4Inheritance

open class Animal(open val name: String)

data class WildAnimal(
    override val name: String,
    val type: String,
    val country: String,
    val age: Int
) : Animal(name)


data class DomesticAnimal(
    override val name: String,
    val type: String,
    val country: String,
    val age: Int
) : Animal(name)


fun main() {

    val wildAnimal = WildAnimal("Tiger", "Cat","India", 3)
    println("wildAnimal : $wildAnimal")

    val domesticAnimal = DomesticAnimal("Scooby", "Dog","USA", 3)
    println("domesticAnimal: $domesticAnimal")

}