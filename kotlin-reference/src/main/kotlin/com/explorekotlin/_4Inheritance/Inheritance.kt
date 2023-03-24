package com.explorekotlin._4Inheritance

open class Person{
    open fun validate(){
        println("Inside Person validate")
    }

}

open class Customer : Person() {

    /*constructor() : super() {

    }*/
   final override fun validate(){
        super.validate()
        println("Inside Customer validate")
    }
}


class SpecialCustomer : Customer(){

    fun validate1() {
        super.validate()
    }

}


fun main() {

    val customer = Customer()
    customer.validate()

}