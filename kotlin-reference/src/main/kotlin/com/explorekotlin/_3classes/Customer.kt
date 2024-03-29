package com.explorekotlin._3classes

import java.io.IOException
import java.time.LocalDate
import kotlin.jvm.Throws

/*
class Customer (initId: Int,initName : String ) {
    var id : Int = initId
    var name : String = initName
}
*/

class Customer(
    val id: Int,
    var name: String = "",
    val email: String = "",
    val yearOfBirth: Int = 0
) {

    @JvmField
    var property = "Value"

    @JvmOverloads
    fun printString(str: String = "default"){
        println("str : $str ")
    }

    @JvmName("changedName")
    fun changeName(){
        println("changeName")
    }

    @Throws(IOException::class)
    fun readFile(fileName: String){
        if (fileName == ""){
            throw  IOException("File Name is empty")
        }
    }

    /*   init {
           name = name.toUpperCase()
       }
   */
    constructor(email: String) : this(0, email = email) {
    }

    val age: Int
        get() {
            return LocalDate.now().year - yearOfBirth
        }
    var phoneNumber : String = ""
    set(value)  {
        if(value.length < 10){
            throw IllegalArgumentException("Phone Number should be 10 characters")
        }
        field = value // field is a special one which is also known as a  backing field value holds the value of that property
    }

}


fun main() {

    val customer = Customer(1, "Dilip", yearOfBirth = 1987)
    customer.phoneNumber = "1231231231"
    println("customer name : ${customer.name}")
    println("Age is ${customer.age}")

    val customer1 = Customer(1)
    val customer2 = Customer("dilip@abc.com")

}