package com.explorekotlin._4Inheritance

interface CourseRepository {
    val isCoursePublished : Boolean
        get() = false

    fun saveCourse(course: Course): Int {
        println("course : $course")
        return course.id
    }

    fun getById(id: Int): Course

}

class SqlCourseRepository : CourseRepository {

    override fun getById(id: Int): Course {
        TODO("Not yet implemented")
    }

    override fun saveCourse(course: Course): Int {
        println("course in SqlCourseRepository : $course")
        return course.id
    }
    override var isCoursePublished: Boolean = false
        get() {
            return true
        }
    set(value) {
        field = value
    }

}


data class Course(val id: Int, val name: String) {
}

interface A {

    fun doSomething(){
        println("Do Something in A")
    }
}

interface B {
    fun doSomething(){
        println("Do Something in B")
    }
}

class AB : A, B {
    override fun doSomething() {
        super<A>.doSomething()
        println("Do something in AB")

    }

}

fun main() {

    val course = Course(1, "Build Rest Services using Spring and Kotlin")
    val sqlCourseRepository = SqlCourseRepository()
    sqlCourseRepository.isCoursePublished = true
    val savedId = sqlCourseRepository.saveCourse(course)
    println("savedId : $savedId")

    val ab = AB()
    ab.doSomething()

}