package com.explorekotlin.domain

class ResponseMap {
    var responseMap: Map<String, Double> = mutableMapOf()
        set(value) {
            field.plus(value)
        }
        get() = field
}

fun main() {

    val responseMap = ResponseMap()
    responseMap.responseMap = mapOf("abc" to 3.99)
    println("responseMap ${responseMap.responseMap}")

}