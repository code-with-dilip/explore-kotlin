package com.explorekotlin.basics


fun main() {

    val range = 1..100
    for (i in range){
        println(i)
    }

    val reverseRange = 100 downTo 1
    for (i in reverseRange){
        println("Reverse range is : $i")
    }

    for (i in reverseRange step 10){
        println("Reverse range is : $i")
    }

    val names = listOf("adam","ben", "chloe")
    for (name in names){
        println("Name is : $name")
    }

    whileLoop()
    doWhileLoop()
    foo()
    customLabelBreak()
    customLabelContinue()
}

private fun whileLoop() {
    var x = 1;
    while (x < 5) {
        println("Inside while : $x")
        x++
    }
}

private fun doWhileLoop() {

    var x = 0
    do {
        println("Inside do while : $x")
        x++
    }while (x < 5)
}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with implicit label")
}

fun customLabelBreak(){

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            println("j is $j")
            if (j==10) break@loop
        }
    }
}

fun customLabelContinue(){

    loop@ for (i in 1..100) {
        println()
        println("i is $i")
       innerLoop@ for (j in 1..100) {
            print("j is $j")
            //if (j==10) continue@loop
           if (j==10) break@innerLoop
        }
    }
}
