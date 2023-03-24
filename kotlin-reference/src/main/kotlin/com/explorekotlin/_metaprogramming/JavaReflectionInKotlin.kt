package com.explorekotlin._metaprogramming

import java.lang.reflect.Type


class Transaction(val id: Int, val amount: Double, var description:String){

    fun printAmount(){
        if(this.amount > 1000){
            println("Huge Transaction")
        }
    }
}

fun introspected(obj: Any){
    println("className using Reflection ${obj.javaClass.simpleName}")
    obj.javaClass.fields.forEach {
        println("Field name : ${it.name} and type is ${it.type}")
    }
    println("Functions:\n")

    obj.javaClass.methods.forEach {
        println("Method name is : ${it.name}")
    }
}

fun getType(type: Type): String? {

    return type.typeName

}

fun main() {

   // introspected(Transaction(1, 10000.0, "Big Transacction"))
    println(getType(Transaction::class.java))
}
