package com.explorekotlin._3classes

enum class PriorityEnum(val value: Int) {
    MINOR(-1) {
        override fun toString(): String {
            return "MINOR PRIORITY"
        }
    },
    NORMAL(0),
    MAJOR(1),
    CRITICAL(2);

    fun abc(){
    }
}

fun main() {

    val priority = PriorityEnum.CRITICAL
    println(priority.name)
    println(priority.ordinal)
    println(priority.value)

    val priorityMinor = PriorityEnum.MINOR
    println(priorityMinor)
    println("name : ${priorityMinor.name}")
    println("ordinal :  ${priorityMinor.ordinal}")
    println("value :  ${priorityMinor.value}")

    for (p in PriorityEnum.values()) {
        println(p.name)
    }

    val priorityEnum = PriorityEnum.valueOf("CRITICAL")
    println("priorityEnum : $priorityEnum")


    enumNotPresent()


}

private fun enumNotPresent() {
    try {
        val priorityEnum1 = PriorityEnum.valueOf("CRITICAL1")
    } catch (ex: Exception) {
        println("ex : $ex")
    }

}