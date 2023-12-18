import com.explorekotlin._4Inheritance.Customer
import com.explorekotlin._4Inheritance.Employee1
import com.explorekotlin.generics.customMap
import com.explorekotlin.generics.penultimate

interface Repository<T> {
    fun getById(id: Int): T
    fun getAll(): List<T>

}

class NullRepository<T : Any> {
    fun size(s: T): String {
        return s.toString()
    }
}

open class StringRepository<T> : Repository<T> {
    override fun getById(id: Int): T {
        TODO("Not yet implemented")
    }

    fun size(s: T): Int {
        return s.hashCode()
    }

    override fun getAll(): List<T> {
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


fun main() {

    val customerRepo = GenericRepositoryImpl<Customer>()

    val employeeRepo = GenericRepositoryImpl<Employee1>()

    val stringRepository = NullRepository<String>()
    val hash = stringRepository.size("")
    println("hash : $hash")

}

