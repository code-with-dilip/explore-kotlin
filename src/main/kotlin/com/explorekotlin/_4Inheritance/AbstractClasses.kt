package com.explorekotlin._4Inheritance

abstract class AbstractPerson{
    var isAlive : Boolean = true
    abstract fun action()

    fun alive(): String {
        return isAlive.toString()
    }
}

class Employee : AbstractPerson(){
    override fun action() {
        TODO("Not yet implemented")
    }

}

fun main() {
    //val person = AbstractPerson()
    val employee = Employee()
    employee.isAlive

}
