package com.explorekotlin.inlinefunctions


fun operation(op: () -> Unit) {
    println("Before Operation")
    op()
    println("after Operation")
}

fun twoOperations(op: () -> Unit, op1: () -> Unit) {
    println("Before Operation")
    op()
    op1()
    println("after Operation")
}

inline fun inlineOperation(op: () -> Unit) {
    println("Before inlineOperation")
    op()
    //throw Exception("I am the greatest exception")
    println("after inlineOperation")
}

inline fun illegalInline(op: () -> Unit) {
    println("Before inlineOperation")
    val op1 = op
    op()
    //throw Exception("I am the greatest exception")
    println("after inlineOperation")
}


fun main() {
    operation { println("I am the operation") }
    inlineOperation { println("I am the in-operation") }

    twoOperations({ println("I am the operation") })
    { println("I am the operation") }
}