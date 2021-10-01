package ru.netology.nmedia.repository

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemory : PostRepository {

    private companion object {
        val defaultPosts = listOf(
            Post(
                id = 0,
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
                published = "21 мая в 18:36",
                author = "Нетология. Университет интернет-профессий будущего",
                likes = 10,
                shares = 1598L,
                views = 1135000L
            ),
            Post(
                id = 1,
                content = "Привет, это новая Нетология! Пост № 2",
                published = "22 мая в 18:36",
                author = "Нетология. Университет интернет-профессий будущего",
                likes = 0,
                shares = 0,
                views = 10
            ),
            Post(
                id = 2,
                content = "Привет, это новая Нетология! Пост № 3",
                published = "25 мая в 18:36",
                author = "Нетология. Университет интернет-профессий будущего",
                likes = 3,
                shares = 8,
                views = 100
            ),
            Post(
                id = 3,
                content = "Привет, это новая Нетология! Четвертый пост",
                published = "26 мая в 18:36",
                author = "Нетология. Университет интернет-профессий будущего",
                likes = 0,
                shares = 0,
                views = 0
            ),
            Post(
                id = 4,
                content = "Привет, это новая Нетология! А это уже тост!",
                published = "27 мая в 18:36",
                author = "Нетология. Университет интернет-профессий будущего",
                likes = 999,
                shares = 999,
                views = 999
            ),
            Post(
                id = 5,
                content = "Привет, это новая Нетология! Пост № 5",
                published = "28 мая в 18:36",
                author = "Нетология. Университет интернет-профессий будущего",
                likes = 0,
                shares = 0,
                views = 0
            ),
            Post(
                id = 6,
                content = "Привет, это новая Нетология! Пост № 6",
                published = "29 мая в 18:36",
                author = "Нетология. Университет интернет-профессий будущего",
                likes = 0,
                shares = 0,
                views = 10
            )
        )
    }
    override val data = MutableLiveData(defaultPosts)

    override fun likeById(id: Long) {
        val currentPosts: List<Post> = data.value ?: return
        val result = currentPosts.map {
            if (it.id != id) it else
                it.copy(likedByMe = !it.likedByMe, likes = if (it.likedByMe) it.likes -1 else it.likes +1)
        }
        data.value = result

    }

    override fun shareById(id: Long) {
        val currentPosts: List<Post> = data.value ?: return
        val result = currentPosts.map {
            if (it.id == id) it.copy(shares = it.shares +1) else it
        }
        data.value = result

    }
}
