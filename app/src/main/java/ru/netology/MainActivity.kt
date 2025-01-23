package ru.netology
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.databinding.ActivityMainBinding
import ru.netology.dto.Post
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var post = Post()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //binding.author.text = "Author"
        setContentView(binding.root)
        applyInset(binding.main)
        binding.root.setOnClickListener {
            post = post.copy(content = post.content + "\nRoot clicked")
            updatePost(binding)
        }
        binding.avatar.setOnClickListener {
            post = post.copy(content = post.content + "\nAvatar clicked")
            updatePost(binding)
        }
        binding.menu.setOnClickListener {
            val n = if (Random.nextInt(2) > 0) {
                Random.nextInt(1_000_000_000)
            } else {
                Random.nextInt(1_000_000)
            }
            val formatted = formatNumber(n)
            val text = "$n -> $formatted"
            post = post.copy(content = text)
            updatePost(binding)
        }
        binding.likeButton.setOnClickListener {
            if (post.likedByMe) {
                binding.likeButton.setImageResource(R.drawable.ic_like)
                post.likes -= 1
            } else {
                binding.likeButton.setImageResource(R.drawable.ic_liked)
                post.likes += 1
            }
            post.likedByMe = !post.likedByMe
            updatePost(binding)
        }
        binding.sharedIcon.setOnClickListener {
            post.shared += 1
            updatePost(binding)
        }
        updatePost(binding)
    }
    private fun updatePost(binding: ActivityMainBinding) {
        binding.avatar.setImageResource(R.drawable.ic_launcher_foreground)
        binding.author.text = post.author
        binding.published.text = post.published
        binding.content.text = post.content
        if (post.likedByMe) {
            binding.likeButton.setImageResource(R.drawable.ic_liked)
        } else {
            binding.likeButton.setImageResource(R.drawable.ic_like)
        }
        binding.likes.text = formatNumber(post.likes)
        binding.shared.text = formatNumber(post.shared)
        binding.views.text = formatNumber(post.views)
    }

    private fun applyInset(main: View) {
        ViewCompat.setOnApplyWindowInsetsListener(main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                v.paddingLeft + systemBars.left,
                v.paddingTop + systemBars.top,
                v.paddingRight + systemBars.right,
                v.paddingBottom+ systemBars.bottom
            )
            insets
        }
    }
}