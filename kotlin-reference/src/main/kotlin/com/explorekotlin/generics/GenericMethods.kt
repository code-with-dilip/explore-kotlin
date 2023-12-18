package com.explorekotlin.generics

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule

val objectMapper: ObjectMapper = ObjectMapper().registerModule(
    KotlinModule.Builder()
        .withReflectionCacheSize(512)
        .configure(KotlinFeature.NullToEmptyCollection, false)
        .configure(KotlinFeature.NullToEmptyMap, false)
        .configure(KotlinFeature.NullIsSameAsDefault, false)
        .configure(KotlinFeature.StrictNullChecks, false)
        .build()
).registerModule(JavaTimeModule())

fun <T> parseToObj(json: String , clazz : Class<T>): T {
    return objectMapper.readValue(json, clazz)
}


internal fun <T> Iterable<T>.collectionSizeOrDefault(default: Int): Int =
    if (this is Collection<*>) this.size else default

fun <T, R> List<T>.customMap(transform: (T) -> R): List<R> {
    val resultCollection = ArrayList<R>(collectionSizeOrDefault(10))
    for (item in this)
        resultCollection.add(transform(item))

    return resultCollection
}

val <T> List<T>.penultimate : T
    get() = this[size-2]

fun <T, R> String.convertToCharList(): List<String> {
    return this
        .split("")
        .toList()

}

fun <T : Number> List<T>.sumAll(): Int {
    var count = 0;
    for (item in this) {
        count += item.toInt()
    }
    return count
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun main() {

    val authors = listOf("Dmitry", "Svetlana")
    val authorNameSizeList = authors
        .customMap { it.length }
    println("authorNameSizeList : $authorNameSizeList")

    val numbers = listOf(1, 2,3,4)
    val result = numbers.penultimate
    println("result : $result")

    val sumResult = numbers.sumAll()
    println("sumResult : $sumResult")

    val numbersDoubleList = listOf(1.0, 2.0, 3.0, 4.0)
    val sumAllDouble = numbersDoubleList.sumAll()
    println("sumAllDouble : $sumAllDouble")

    val max = max("Dilip", "Yaash")
    println("max : $max")

}