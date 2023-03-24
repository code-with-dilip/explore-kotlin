package com.explorekotlin._10interoperability


import com.explorekotlin.domain.CustomerJava
import com.explorekotlin.domain.CustomerRepository

class ReturningCustomer(
    val id: Int,
    var name1: String,
    val email1: String
) : CustomerJava(id, name1, email1)



fun ReturningCustomer.extenstion() {
    println("Inside Extension Function")
}

class CustomerRepositoryImpl : CustomerRepository {
    override fun findById(id: Int?): CustomerJava? {
        TODO("Not yet implemented")
    }

    override fun findCustomers(): MutableList<CustomerJava>? {
        TODO("Not yet implemented")
    }
}


fun main() {

    val customerRepositoryImpl = CustomerRepositoryImpl()

    val customer = customerRepositoryImpl.findById(11)
    customer?.name
}