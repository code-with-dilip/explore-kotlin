package com.explorekotlin.generics

import com.explorekotlin._4Inheritance.Customer
import com.explorekotlin._4Inheritance.Employee1


interface Repository<T>{
    fun getById(id: Int) : T
    fun getAll() : List<T>
}

class GenericRepositoryImpl<T> : Repository<T> {
    override fun getById(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }
}

 interface Repo {
     fun <T> getById() : T
     fun <R> getAll() : List<R>
 }

class RepoImpl : Repo {
    override fun <T> getById(): T {
        TODO("Not yet implemented")
    }

    override fun <R> getAll(): List<R> {
        TODO("Not yet implemented")
    }
}


fun main() {

    val customerRepo = GenericRepositoryImpl<Customer>()

    val employeeRepo = GenericRepositoryImpl<Employee1>()


}