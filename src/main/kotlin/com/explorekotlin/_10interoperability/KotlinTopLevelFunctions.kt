@file:JvmName(name="CommonUtilities")
package com.explorekotlin._10interoperability

fun prefix(prefix: String, value: String): String {
    return "$prefix-$value"
}