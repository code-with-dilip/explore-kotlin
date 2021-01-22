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

fun sum(x: Int,y: Int) = x +y


fun main() {

    println(operation(1, 2, ::sum))

    println("Addition : ${operation(1, 2) { x, y -> x + y }}")

    println("Multiplication : ${operation(1, 2) { x, y -> x * y }}")

    println("abc1".filter { (it in 'a'..'z')   })
}