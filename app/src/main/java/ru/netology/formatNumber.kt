package ru.netology

fun formatNumber(n: Int): String {
    if (n < 0) {
        throw IllegalArgumentException("Cannot be negative!")
    }
    if (n < 1000) {
        return n.toString()
    }
    if (n < 1_000_000) {
        val t = n / 1000
        val h = (n % 1000) / 100
        if (h > 0 && n < 10_000) {
            return "$t.$h" + "K"
        }
        return "$t" + "K"
    }
    val m = n / 1_000_000
    val h = (n % 1_000_000) / 100_000
    if (h > 0 && n < 10_000_0000) {
        return "$m.$h" + "M"
    }
    return "$m" + "M"
}