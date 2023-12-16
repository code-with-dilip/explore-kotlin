package com.explorekotlin.generics

import com.explorekotlin._4Inheritance.Customer
import com.explorekotlin._4Inheritance.Employee1


interface Repository<T> {
    fun getById(id: Int): T
    fun getAll(): List<T>
}

open class GenericRepositoryImpl<T> : Repository<T> {
    override fun getById(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }
}


interface Repo {
    fun <T> getById(): T
    fun <R> getAll(): List<R>
}

class RepoImpl : Repo {
    override fun <T> getById(): T {
        TODO("Not yet implemented")
    }

    override fun <R> getAll(): List<R> {
        TODO("Not yet implemented")
    }
}

internal fun <T> Iterable<T>.collectionSizeOrDefault(default: Int): Int =
    if (this is Collection<*>) this.size else default

fun <T, R> List<T>.customMap(transform: (T) -> R): List<R> {
    val resultCollection = ArrayList<R>(collectionSizeOrDefault(10))
    for (item in this)
        resultCollection.add(transform(item))

    return resultCollection
}

val <T> List<T>.penultimate : T
    get() = this[size-2]

fun <T, R> String.convertToCharList(): List<String> {
    return this
        .split("")
        .toList()

}


fun main() {

    val customerRepo = GenericRepositoryImpl<Customer>()

    val employeeRepo = GenericRepositoryImpl<Employee1>()

    val authors = listOf("Dmitry", "Svetlana")
    val customAuthors = authors
        .customMap { it.length }

    val numbers = listOf(1, 2,3,4)
    val result = numbers.penultimate
    println("result : $result")

}