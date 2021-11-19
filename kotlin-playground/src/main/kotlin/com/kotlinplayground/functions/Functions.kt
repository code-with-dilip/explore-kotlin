package com.kotlinplayground.functions

fun printDetails(){
    println("Hello!")
}

fun printName(name: String){
    println("Name is $name")
}

fun addition(x: Int, y : Int): Int {
    return x+y
}


/**
 *
 * This just accepts arbitary number of arguments
 */
fun printMultipleThings(vararg  alphabets: String){
    println("strings : $alphabets")
    for(alphabet in alphabets ){
        println(alphabet)
    }

    //val alphabetList = listOf(alphabets)
    val alphabetList = listOf(*alphabets) // this is also called spread operator
    println("alphabetList : $alphabetList")

}

fun main() {
    printDetails()
    printName("Dilip")
    val result = addition(2,3)
    println("Result is $result")
    printMultipleThings("A", "B", "C")
}