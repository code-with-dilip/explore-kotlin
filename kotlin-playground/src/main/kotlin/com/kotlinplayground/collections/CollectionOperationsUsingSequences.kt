package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.courseList
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun main() {

    val developmentCourses = filterCourses(courseList(), CourseCategory.DEVELOPEMENT)
    println("developmentCourses : $developmentCourses and devcourses size : ${developmentCourses.size}")
    lazyEvaluation()
    eagerEvaluation()

}


private fun filterCourses(courseList: MutableList<Course>, courseCategory: CourseCategory): List<Course> {
    val courses = courseList
        .asSequence()
        .filter {
            it.category == courseCategory
        }
        .toList()
    return courses
}

@OptIn(ExperimentalTime::class)
private fun eagerEvaluation() {
    val timeTaken = measureTime {
        val intRange = 1..1_000_000_000
        val output = intRange.filter { it < 40 } // intermediate collection
        println(output)
    }

    println("timetaken in eagerEvaluation: $timeTaken")
}

@OptIn(ExperimentalTime::class)
private fun lazyEvaluation() {
    val timeTaken = measureTime {
        val intRange = 1..1_000_000_000
        val output = intRange.asSequence()
            .filter { it < 40 } //each and every individual element
            .toList()
        /*.forEach {
            println(it)
        }*/
        println(output)
    }

    println("timetaken in lazyEvaluation: $timeTaken")
}