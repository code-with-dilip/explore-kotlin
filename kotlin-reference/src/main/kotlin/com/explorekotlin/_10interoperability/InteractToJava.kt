package com.explorekotlin._10interoperability

import com.explorekotlin.domain.CustomerJava

fun main() {

    val customer = CustomerJava()
    customer.email = "dilip@abc.com"
    customer.name = "Dilip"
    customer.printDetails()

    customer.nonNull()



}