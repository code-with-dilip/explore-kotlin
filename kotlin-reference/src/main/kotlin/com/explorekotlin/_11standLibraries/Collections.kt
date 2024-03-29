package com.explorekotlin._11standLibraries

class Collections {
}

fun main() {

    val names = listOf("adam", "ben", "chloe")
    println(names)

    val emptyList = emptyList<String>()
    println(emptyList)

    val namesMutable = mutableListOf("adam", "ben", "chloe")
    namesMutable.add("anna")
    println(namesMutable)

    val hashMap = hashMapOf(Pair("dilip", 33), Pair("scooby", 4), Pair("yaash", 2))
    println(hashMap)

    val hashMap1 = hashMapOf("dilip" to 33, "scooby" to 4, "yaash" to 2)
    println(hashMap1)

    val mutableMap = mutableMapOf("dilip" to 33, "scooby" to 4, "yaash" to 2)
    mutableMap.put("abc", 100)
    println(mutableMap)

    val set = setOf("adam", "ben", "chloe")
    println(set)

    val mutableSet = mutableSetOf("adam", "ben", "chloe")
    println(mutableSet)

    collections_nullability()

}

private fun collections_nullability() {
    val list: List<String>? = null /*?: listOf()*/

    list?.forEach {

    }

    val list1: List<String?> = listOf("alex", null, "adam")

    list1
        .forEach {
            println(it?.length)
        }
}