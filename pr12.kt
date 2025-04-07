import kotlinx.coroutines.*
import kotlin.math.pow

suspend fun main() = coroutineScope {
    try {
        print("Введите количество операций: ")
        val count = readln().toInt()
        var finalText = ""

        for (i in 0 until count) {
            launch {
                val info = calculateSomething(i)
                finalText += info
            }
        }

        delay(100L * count)

        println("Результаты вычислений:\n$finalText")

    } catch (e: NumberFormatException) {
        println("Ошибка: введите целое число!")
    }
}

fun calculateSomething(index: Int): String {
    val a = index
    val b = 5
    val sum = a + b
    val power = a.toDouble().pow(b.toDouble())

    return "Сложение #${index + 1}: $a + $b = $sum\n" +
            "Степень   #${index + 1}: $a ^ $b = $power\n"
}