package com.thechance.task_week9.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thechance.task_week9.R
import com.thechance.task_week9.data_related.StoryModel
import com.thechance.task_week9.databinding.ItemStoryBinding
import java.lang.Exception

class StoriesAdapter(
    private val items: List<StoryModel>
) :
    RecyclerView.Adapter<StoriesAdapter.BaseStoryViewHolder>() {

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_STORY
            else -> VIEW_TYPE_STORY
        }
    }

    class StoryViewHolder(itemView: View) : BaseStoryViewHolder(itemView) {
        val binding = ItemStoryBinding.bind(itemView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseStoryViewHolder {
        return when (viewType) {
            VIEW_TYPE_STORY -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
                StoryViewHolder(view)
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: BaseStoryViewHolder, position: Int) {
        when (holder) {
            is StoryViewHolder -> bindStory(holder, position)
        }
    }

    private fun bindStory(holder: StoryViewHolder, position: Int) {
        val currentStory = items[position]

        holder.binding.apply {
            textUsername.text = currentStory.username
            Glide.with(this.root.context).load(currentStory.imgUrl).into(storyImage)
        }
    }


    abstract class BaseStoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    companion object {
        private const val VIEW_TYPE_ADD_STORY = 1
        private const val VIEW_TYPE_STORY = 2
    }
}