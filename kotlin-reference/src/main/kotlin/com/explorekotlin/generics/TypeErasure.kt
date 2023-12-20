package com.explorekotlin.generics


fun checkType(input : Collection<*>) {

        val list = input as? List<Int> ?:
        throw IllegalArgumentException("Exception")

        println("Sum is ${list.sum()}")

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


fun main() {
    val stringList = listOf("abc", "def")

    val intList = listOf(1, 2)
    val intSet = setOf(1, 2)

    checkType(intList)
    //checkType(stringList)
   // checkType(intSet)

    val inputList = listOf("abc", 1, "def", 2)
    val output  = inputList.filterInstance<String>()
    println("output : $output")
}