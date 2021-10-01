package ru.netology.nmedia.dto

data class Post(
    val id: Long = 0L,
    val content: String = "",
    val published: String = "",
    val author: String = "",
    val likedByMe: Boolean = false,
    val likes: Long = 16123L,
    val shares: Long = 1598L,
    val views: Long = 1135000L
)

fun longToString(param: Long): String {
    when {
        param in 1000..9999 -> return "1." + (param % 1000 / 100).toString() + "K"
        param in 10000..999999 ->
            return (param / 10000).toString() + "." + (param % 10000 / 1000).toString() + "K"
        param >= 1000000 ->
            return (param / 1000000).toString() + "." + (param % 1000000 / 100000).toString() + "M"
    }
    return param.toString()
}

