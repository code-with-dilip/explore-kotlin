package com.explorekotlin._Tidbits


open class Person {

}

class Employee : Person() {

    fun vacationDays(days: Int) {
        if (days < 60) {
            println("You need to take more vacation")
        }
    }

}

class Contractor : Person() {

}

fun checkTypeOfPerson(person: Person) {

    if(person is Employee){
        person.vacationDays(10)
    }

}

fun main() {

    val employee = Employee()
    val count : Any = 10

    val castValue = count as Int
    println("count : $count")
    val castValue1 = count as? String


}