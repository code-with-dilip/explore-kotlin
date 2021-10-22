package com.explorekotlin._1basics

//import com.explorekotlin.basics.commons.strToLength
import com.explorekotlin._1basics.commons.strToLength as strLength

fun main() {

    val name = "Alex"

    if (name.length == 4) {
        println("Length is 4 and the name is $name")
    } else {
        println("Length is not 4 and the name is $name")
    }

    //ifExpression(name)
    //whenBlock(name)
    whenBlockExpression(name)

    println("Length of the String is ${strLength(name)}")



}

fun whenBlock(name: String) {

   /* when (name) {
        "Alex" -> println("Name is Alex")
        "Ben" -> println("Name is Ben")
    }*/

    when (name.length) {
        4 -> println("Length of the name is 4")
        5 -> println("Length of the name is 5")
    }


}

fun whenBlockExpression(name: String) {

    val whenResult =  when (name.length) {
        4 -> {
            println("Length of the name is 4")
            name
        }
        5 -> {
            println("Length of the name is 5")
            name
        }
        else -> {
            println("Length of the name is not 4 or 5")
            ""
        }
    }
    println(whenResult)

}

private fun ifExpression(name: String) {
    val resultName = if (name.length == 4) {
        println("Length is 4 and the name is $name")
        name.toUpperCase()
    } else if (name.length == 5) {
        println("Length is not 5 and the name is $name")
        name.toUpperCase()
    } else {
        println("Length is not 4 and 5 and the name is $name")
        name.toUpperCase()
    }

    println("resultName : $resultName")
}