package com.explorekotlin.higher_order_functions

fun String.filter(predicate : (Char) -> Boolean): String {
    val sb = StringBuilder()
    println("String  is $this");
    for (index in 0 until length){
        val element = get(index)
        if(predicate(element)) sb.append(element)
    }
    return sb.toString()

}

fun operation(x : Int, y :Int , op : (Int, Int)-> Int): Int {
    return op(x, y)
}



fun str() : String? = null

fun sum(x: Int,y: Int) = x +y


fun main() {

    println(operation(1, 2, ::sum))

    println("Result is : ${operation(1, 2) {x,y -> x-y} }")

    for (i in 1..5) {
        println("i is $i")
    }

    try {
        str()!!
    }catch (ex: Exception){
        println("ex : $ex")
    }


    println("Status is ${"inactive".contains("active")}")
    println("Status is ${"LES_INACTIVE".toLowerCase().contains("active")}")

}