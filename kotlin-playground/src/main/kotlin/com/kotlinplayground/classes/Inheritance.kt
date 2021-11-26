package com.kotlinplayground.classes

open class User(open val name: String){
    open fun login(){
        println("Inside user login")
    }
}

class Student(override val name: String) : User(name){
    override fun login(){
        super.login()
        println("Inside Student login")
    }
}

class Instructor(name: String) : User(name){
    override fun login(){
        println("Inside Instructor login")
    }
}

fun main() {

    val student = Student("Dilip")
    student.login()

    /*val instructor = Instructor("Dilip")
    instructor.login()*/
}
