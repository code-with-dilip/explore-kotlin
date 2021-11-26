package com.kotlinplayground.classes

class Person(val name: String = "",
             val age: Int = 0) {

    var email: String = ""
    var nameLength : Int = 0
    init {
        println("Inside Init Block")
        nameLength = name.length
    }

    constructor(
        _email: String) : this() {
        email =_email
    }

    fun action() {
        println("Person Walks")
    }

}


class Item() {
    var name : String = ""
    constructor(_name : String) : this(){
        name = _name
    }
}


fun main() {

    val person = Person("Alex", 25) // new keyword is not needed
    person.action()
    println("Length Of the name : ${person.nameLength}")

    val person1 = Person() // new keyword is not needed
    //person1.action()

    val person2 = Person(_email = "abc@gmail.com") // new keyword is not needed
    person1.action()
    println("Email is : ${person2.email}")

    val item = Item("Iphone")
    println("Item name is ${item.name}")

}