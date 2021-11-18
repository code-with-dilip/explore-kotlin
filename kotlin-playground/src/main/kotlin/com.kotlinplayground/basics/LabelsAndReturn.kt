package com.kotlinplayground.basics

fun main() {

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
