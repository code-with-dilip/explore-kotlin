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

