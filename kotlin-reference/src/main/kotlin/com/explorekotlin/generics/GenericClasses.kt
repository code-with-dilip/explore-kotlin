import com.explorekotlin._4Inheritance.Customer
import com.explorekotlin._4Inheritance.Employee1
import com.explorekotlin.generics.customMap
import com.explorekotlin.generics.penultimate

interface Repository<T> {
    fun getById(id: Int): T
    fun getAll(): List<T>
}

open class StringRepository<String> : Repository<String> {
    override fun getById(id: Int): String {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<String> {
        TODO("Not yet implemented")
    }
}

open class GenericRepositoryImpl<T> : Repository<T> {
    override fun getById(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }
}


fun <T : Number> List<T>.sumAll(): Int {
    var count = 0;
    for (item in this) {
        count += item.toInt()
    }
    return count
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun main() {

    val customerRepo = GenericRepositoryImpl<Customer>()

    val employeeRepo = GenericRepositoryImpl<Employee1>()

    val authors = listOf("Dmitry", "Svetlana")
    val customAuthors = authors
        .customMap { it.length }

    val numbers = listOf(1, 2, 3, 4)
    val result = numbers.penultimate
    println("result : $result")

    val sumResult = numbers.sumAll()
    println("sumResult : $sumResult")

    val numbersDoubleList = listOf(1.0, 2.0, 3.0, 4.0)
    val sumAllDouble = numbersDoubleList.sumAll()
    println("sumAllDouble : $sumAllDouble")

    val max = max("Dilip", "Yaash")
    println("max : $max")


}

