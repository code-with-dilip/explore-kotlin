package com.explorekotlin._metaprogramming

@Target(AnnotationTarget.CLASS)
@Repeatable
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class  Table(val name: String)

@Target(AnnotationTarget.FIELD)
@MustBeDocumented
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
annotation class  Field(val name: String)

@Table(name = "Contact_Table")
data class Contact(val id: Int, @Field(name="column_name")val name: String, val email: String)

fun main() {

    val annotation = Contact::class.annotations.find { it.annotationClass.simpleName == "Table" }
    println(annotation)
}