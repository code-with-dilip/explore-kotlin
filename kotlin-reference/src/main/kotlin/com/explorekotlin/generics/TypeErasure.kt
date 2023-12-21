package com.explorekotlin.generics

import com.explorekotlin._4Inheritance.Course
import java.security.Provider
import java.util.*
import kotlin.collections.ArrayList


fun checkType(input : Collection<*>) {

        val list = input as? List<Int> ?:
        throw IllegalArgumentException("Exception")

        println("Sum is ${list.sum()}")

}

class Service

val serviceImpl = ServiceLoader.load(Service::class.java)

inline fun <reified T> loadService(classs : T) : ServiceLoader<T>{
    return ServiceLoader.load(T::class.java)
}


inline fun <reified T> isA(value : Any ) = value is T

inline fun <reified T>  List<*>.filterInstance() : List<T> {
    val returnList = ArrayList<T>()
    for(item in this){
        if(item is T){
            returnList.add(item)
        }
    }
    return returnList
}

inline fun <reified T>  List<T>.filterInstance1() : List<T> {
    val returnList = ArrayList<T>()
    for(item in this){
        if(item is T){
            returnList.add(item)
        }
    }
    return returnList
}


fun main() {
    val stringList = listOf("abc", "def", "1")

    val intList = listOf(1, 2)
    val intSet = setOf(1, 2)

    checkType(intList)
    //checkType(stringList)
   // checkType(intSet)

    val inputList = listOf("abc", 1, "def", 2,Course(1, "abc"))
    val output  = inputList.filterInstance<String>()
    println("output : $output")

    val output1  = inputList.filterInstance1()

}