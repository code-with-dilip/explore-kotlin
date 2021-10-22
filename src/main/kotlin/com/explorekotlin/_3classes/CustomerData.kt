package com.explorekotlin._3classes

data class CustomerData(  val id: Int,
                          var name: String = "",
                          val email: String = "",
                          val yearOfBirth: Int = 0)

fun main() {

    val customer = CustomerData(1, "Dilip", yearOfBirth = 1987)
    println(customer)
    val customer1 = CustomerData(1, "Dilip", yearOfBirth = 1987)
    if(customer == customer1){
        println("The customers are equal")
    }else{
        println("The customers are not equal")
    }

}