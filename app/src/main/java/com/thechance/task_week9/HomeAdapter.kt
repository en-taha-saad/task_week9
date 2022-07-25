package com.thechance.task_week9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thechance.task_week9.databinding.ItemPostBinding


class HomeAdapter(val items: List<HomeItem<Any>>) :
    RecyclerView.Adapter<HomeAdapter.BaseHomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        return when (viewType) {
            VIEW_TYPE_STORIES -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_stories_list, parent, false)
                PostViewHolder(view)
            }
            VIEW_TYPE_NEW_POST -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_new_post, parent, false)
                PostViewHolder(view)
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
            is NewPostViewHolder -> bindNewPost(holder, position)
            is PostViewHolder -> bindPost(holder, position)
        }
    }

    private fun bindStories(holder: StoriesViewHolder, position: Int) {

    }

    private fun bindNewPost(holder: NewPostViewHolder, position: Int) {

    }

    private fun bindPost(holder: PostViewHolder, position: Int) {

    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            HomeItemType.TYPE_STORIES -> VIEW_TYPE_STORIES
            HomeItemType.TYPE_NEW_POST -> VIEW_TYPE_NEW_POST
            HomeItemType.TYPE_POST -> VIEW_TYPE_POST
        }
    }


    abstract class BaseHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class PostViewHolder(itemView: View) : BaseHomeViewHolder(itemView) {
        val binding = ItemPostBinding.bind(itemView)
    }

    class NewPostViewHolder(itemView: View) : BaseHomeViewHolder(itemView) {
        val binding = ItemNewPostBinding.bind(itemView)
    }

    class StoriesViewHolder(itemView: View) : BaseHomeViewHolder(itemView) {
        val binding = ItemStoriesListBinding.bind(itemView)
    }

    companion object {
        private const val VIEW_TYPE_STORIES = 1
        private const val VIEW_TYPE_NEW_POST = 2
        private const val VIEW_TYPE_POST = 3
    }
}