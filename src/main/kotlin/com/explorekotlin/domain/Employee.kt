package com.explorekotlin.domain

data class Employee(open val id: Int?, open val name:  String,open val age: Int)

class Person(override val id: Int?, override val name: String, override val age: Int) : Employee(id,name,age )

fun main() {

    val employee= Employee(1, "Dilip1", 33)

    val employee1= Employee(2, "Dilip2", 32)
    val employee2= Employee(null, "Dilip3", 31)
    val employee4= Employee(1, "Dilip1", 33)

    val employeeList = mutableListOf(employee,employee1, employee2, employee4)

    val employees  =employeeList.run {
        this.filterNot { it ->
            it.id!=null &&  (this.filter {
                it.age >= 34
            }).count() >= 1
        }
    }

    val result = employeeList
        .distinctBy { it.name }
        .groupBy { listOf(it.name) }

    println("result :  $result")

    println("employees :  $employees")

    val filterEmployees = employeeList.filter { it.age >= 32 }
    println("filterEmployees :  $filterEmployees")

    val filterNotEmployees = employeeList.filterNot { it.age >= 32 }
    println("filterNotEmployees :  $filterNotEmployees")

    println("Employee Equality 1: ${employee == employee1}")
    println("Employee Equality 2: ${employee == employee2}")



}