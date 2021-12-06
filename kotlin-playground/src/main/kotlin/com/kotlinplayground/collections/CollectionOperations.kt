package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.KAFKA
import com.kotlinplayground.dataset.courseList


fun main() {

    val devPredicate = { course: Course -> course.category == CourseCategory.DEVELOPEMENT }
    val desPredicate = { course: Course -> course.category == CourseCategory.DESIGN }

    val courseList = courseList()
    val developmentCourses = courseList.filter {
        //devPredicate
        devPredicate.invoke(it)

    }
    println("developmentCourses : $developmentCourses")

    val designCourses = courseList.filter {
        //devPredicate
        desPredicate.invoke(it)

    }.map {
            //it.name
        "${it.name} -  ${it.category}"
        }
    println("designCourses : $designCourses")

    val kafkaCourses = exploreFlatMap(courseList, KAFKA)
    println("kafkaCourses : $kafkaCourses")
}

private fun exploreFlatMap(developmentCourses: List<Course>, topic: String): List<String> {
    val kafkaCourses = developmentCourses
        .flatMap {
            val courseName = it.name
            it.topicsCovered.filter {
                it == topic
            }.map {
                courseName
            }
        }

    return kafkaCourses
}

private fun filterCourses(courseList: MutableList<Course>, courseCategory: CourseCategory): List<Course> {
    val courses = courseList
        .filter {
            it.category == courseCategory
        }
    return courses
}