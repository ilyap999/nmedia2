package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.longToString

typealias OnLikeListener = (post: Post) -> Unit
typealias OnShareListener = (post: Post) -> Unit

class PostAdapter(
    private val likeListener: OnLikeListener,
    private val shareListener: OnShareListener
): RecyclerView.Adapter<PostViewHolder>() {
    var posts: List<Post> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            likeListener,
            shareListener
        )


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size
}

class PostViewHolder(
    private  val binding: CardPostBinding,
    private val likeListener: OnLikeListener,
    private val shareListener: OnShareListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        with(binding) {
            avatar.setImageResource(R.drawable.ic_netology_48dp)
            content.text = post.content
            author.text = post.author
            published.text = post.published
            textLike.text = longToString(post.likes)
            textShare.text = longToString(post.shares)
            textView.text = longToString(post.views)

            buttonLike.setImageResource(
                if (post.likedByMe) {
                    R.drawable.ic_baseline_favorite_24
                } else {
                    R.drawable.ic_baseline_favorite_border_24
                }
            )
            buttonLike.setOnClickListener {
                likeListener(post)
            }
            buttonShare.setOnClickListener {
                shareListener(post)
            }
        }
    }

}
