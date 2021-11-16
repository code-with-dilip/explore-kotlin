package com.kotlinplayground.domain

data class Instructor(
    override val name: String,
    override val age: Int,
    val noOfCourses : Int,
    val coursesTaught : List<Course>
) : Person(name, age)
