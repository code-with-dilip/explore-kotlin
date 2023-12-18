package com.explorekotlin.comparable


data class FamilyMember(
    val firstName: String,
    val lastName: String,
    val age: Int
) : Comparable<FamilyMember> {
    override fun compareTo(other: FamilyMember): Int {
        val fName = firstName.compareTo(other.firstName)
        val lName = lastName.compareTo(other.lastName)
        return fName.compareTo(lName)
    }

}

var comparatorByName =
    { o1: FamilyMember, o2: FamilyMember ->
        val fName = o1.firstName.compareTo(o2.firstName)
        val lName = o1.lastName.compareTo(o2.lastName)
        fName.compareTo(lName)
    }

fun main() {

    val belchers = mutableListOf(
        FamilyMember("Bob", "Belcher", 45),
        FamilyMember("Linda", "Belcher", 44),
        FamilyMember("Tina", "Belcher", 13),
        FamilyMember("Gene", "Belcher", 11),
        FamilyMember("Louise", "Belcher", 9)
    )
    belchers.sort()

    println("belchers with Comparable: $belchers")

    belchers.sortWith(comparatorByName)

    println("belchers with Comparator : $belchers")

    belchers.sortWith(
        Comparator.comparing(FamilyMember::firstName).thenComparing(FamilyMember::lastName)
    )



}

