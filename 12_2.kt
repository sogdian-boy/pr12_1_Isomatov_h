import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Введите имя пользователя:")
    val Name = readLine()!!
    println("Введите пароль:")
    val pass = readLine()
    println("Выберите режим (1 - обычный, 2 - блокировка):")
    val mode = readLine()!!.toInt()
    println("Загрузка данных...")
    val job = launch {
        val users = loadUsers(Name, mode == 2) //Проверка режима
        users.sortedByDescending { it.repos }.forEach {
            println("${it.name}: ${it.repos} репозиториев")
        }
    }
    job.join()
}
suspend fun loadUsers(New: String, block: Boolean): List<User> {
    if (block) {
        Thread.sleep(3000) // Блокирующая задержка
    } else {
        delay(0) // Неблокирующая задержка
    }
    return listOf(
        User(New,10),
        User("Исоматов", 15),
        User("Зеленовский", 28),
        User("Карамов", 42),
        User("Рогов", 7),
        User("Забелина", 3)
    )
}