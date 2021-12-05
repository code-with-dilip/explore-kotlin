package com.explorekotlin._11standLibraries

import com.kotlinplayground.dataset.KAFKA
import com.kotlinplayground.dataset.courseList
import com.kotlinplayground.domain.CourseCategory


fun main() {

    val courseList = courseList()
    val developmentCourses = filterCourses(courseList, CourseCategory.DEVELOPEMENT)
    println("developmentCourses :  $developmentCourses")

    val businessCourses = filterCourses(courseList, CourseCategory.BUSINESS)
    println("businessCourses : $businessCourses")

    val developmentCourseNames = developmentCourses
        .map { it.name }
    println("developmentCourseNames :  $developmentCourseNames")

    val kafkaCourses = exploreFlatMap(developmentCourses, KAFKA)
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