package com.explorekotlin.arrays

import java.util.Arrays.asList
import java.util.stream.Collectors

fun main() {

    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }

    val myArray3 = arrayOf<String>("CN=APP-PARCEL-QUOTES-USER-NPE,OU=Application,OU=Groupings,DC=corp,DC=target,DC=com","Praveen","Sathya","Yogesh","Ram")
    myArray3.forEach { println(it) }
    val cnGroupArray = arrayOf("CN=APP-ABC-USER-NPE","OU=Application","OU=Groupings","DC=corp","DC=target","DC=com","CN=APP-DEF-USER-NPE","OU=Application","OU=Groupings","DC=corp","DC=target","DC=com" )


    var cnGroupList = mutableListOf<String>()
    var group=""
    cnGroupArray.forEach {
        if(it.contains("DC=com")){
            group+= "$it"
            cnGroupList.add(group)
            group=""
        }else{
            group+="$it,"
        }
    }
    println("cnGroupList : $cnGroupList")

}