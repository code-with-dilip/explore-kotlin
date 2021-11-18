package com.kotlinplayground.basics

fun main() {

    for(i in 1..5){
        println("i is $i ")
        if(i==3) break

    }

    label()

    for (i in 1..10){
        if(i==3) return
        println("Value before return : $i")
    }

}

fun label() {

    loop@ for(i in 1..5){
        println("i in label $i: ")
        innerLoop@ for (j in 1..10){
            //if(j==2) break@innerLoop
            if(j==2) break@loop
        }
    }

}
