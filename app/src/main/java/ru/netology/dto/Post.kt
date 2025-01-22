package ru.netology.dto
/*
* {
      "id": 1,
      "author": "Нетология. Университет интернет-профессий будущего",
      "authorAvatar": "@sample/posts_avatars",
      "published": "21 мая в 18:36",
      "content": "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
      "likes": 19,
      "shared": 4,
      "views": 123
    }
* */
data class Post(
    val id: Long = -1,
    val author: String = "=== Post author ===",
    val published: String = "=== Publishing date ===",
    val content: String = "=== Content text ===",
    var likes: Int = 0,
    var shared: Int = 999,
    var views: Int = 12345,
    var likedByMe: Boolean = false,
    var sharedByMe: Boolean = false
)

