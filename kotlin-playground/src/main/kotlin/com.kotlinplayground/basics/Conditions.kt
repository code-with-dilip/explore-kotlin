package com.kotlinplayground.basics

fun main() {

    val name = "Alex"
    if(name.length == 4){
        println("Name is Four Characters")
    }else{
        println("Name is Not Four Characters")
    }

    //1 -> GOLD, 2-> SILVER, 3 -> BRONZE
    var position = 1
    val medal = if( position == 1)
    {
        "GOLD"
    }else if (position == 2){
        "SILVER"
    }else if (position == 3){
        "BRONZE"
    }else {
        "NO MEDAL"
    }
    println("medal : $medal")

    position = 3
     val medal1 = when(position){
        1 -> "GOLD"
        2 -> "SILVER"
        3 -> {
            println("Inside position 3")
            "BRONZE"
        }
        else -> "NO MEDAL"
    }

    println("medal1 : $medal1")


}
