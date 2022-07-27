package com.thechance.task_week9.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thechance.task_week9.R
import com.thechance.task_week9.data_related.HomeItem
import com.thechance.task_week9.data_related.HomeItemType
import com.thechance.task_week9.data_related.PostModel
import com.thechance.task_week9.data_related.StoryModel
import com.thechance.task_week9.databinding.ItemPostBinding
import com.thechance.task_week9.databinding.ItemStoriesListBinding


class HomeAdapter(private val items: List<HomeItem<Any>>) :
    RecyclerView.Adapter<HomeAdapter.BaseHomeViewHolder>() {

    override fun getItemCount() = items.size
    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            HomeItemType.TYPE_STORIES -> VIEW_TYPE_STORIES
            HomeItemType.TYPE_POST -> VIEW_TYPE_POST
        }
    }

    class PostViewHolder(itemView: View) : BaseHomeViewHolder(itemView) {
        val binding = ItemPostBinding.bind(itemView)
    }

    class StoriesViewHolder(itemView: View) : BaseHomeViewHolder(itemView) {
        val binding = ItemStoriesListBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        return when (viewType) {
            VIEW_TYPE_STORIES -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_stories_list, parent, false)
                StoriesViewHolder(view)
            }
            VIEW_TYPE_POST -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
                PostViewHolder(view)
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        when (holder) {
            is StoriesViewHolder -> bindStories(holder, position)
            is PostViewHolder -> bindPost(holder, position)
        }
    }

    private fun bindStories(holder: StoriesViewHolder, position: Int) {
        val stories = items[position].item as List<StoryModel>
        val adapter = StoriesAdapter(stories)
        holder.binding.apply {
            recyclerStories.adapter = adapter
        }
    }


    private fun bindPost(holder: PostViewHolder, position: Int) {
        val currentPost = items[position].item as PostModel
        holder.binding.apply {
            textUsername.text = currentPost.username

            threeDots.setOnClickListener {
                Toast.makeText(this.root.context, "Three Dots Clicked!", Toast.LENGTH_SHORT).show()
            }
            sendIcon.setOnClickListener {
                Toast.makeText(this.root.context, "Send Icon Clicked!", Toast.LENGTH_SHORT).show()
            }
            saveIcon.setOnClickListener {
                Toast.makeText(this.root.context, "Save Icon Clicked!", Toast.LENGTH_SHORT).show()
            }
            loveIcon.setOnClickListener {
                Toast.makeText(this.root.context, "Love Icon Clicked!", Toast.LENGTH_SHORT).show()
            }
            commentIcon.setOnClickListener {
                Toast.makeText(this.root.context, "Comment Icon Clicked!", Toast.LENGTH_SHORT)
                    .show()
            }
            likes.text = "${currentPost.likes} likes"
            textUsername2.text = currentPost.username
            postDescription.text = currentPost.postDescription
            Glide.with(this.root.context).load(currentPost.profileImgUrl).into(imageProfile)
            Glide.with(this.root.context).load(currentPost.postImgUrl).into(imagePost)

        }

    }


    abstract class BaseHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        private const val VIEW_TYPE_STORIES = 1
        private const val VIEW_TYPE_POST = 2
    }
}