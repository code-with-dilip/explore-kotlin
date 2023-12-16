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


//fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T>
//
//val authors = listOf("Dmitry", "Svetlana")



//fun <T, R> map1(obj : T, op : (T) -> R  ) : R {
//
//    //return op()
//}
