@file:JvmName(name="CommonUtilities")
package com.explorekotlin._10interoperability

val name = "KOTLIN_FILE"
const val NAME_CONSTANT = "KOTLIN_FILE"

fun prefix(prefix: String, value: String): String {
    return "$prefix-$value"
}