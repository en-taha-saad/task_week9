package com.thechance.task_week9.fragments

import android.view.LayoutInflater
import com.thechance.task_week9.adapters.HomeAdapter
import com.thechance.task_week9.data_related.HomeItem
import com.thechance.task_week9.data_related.HomeItemType
import com.thechance.task_week9.base_classes.BaseFragment
import com.thechance.task_week9.data_related.DataSource
import com.thechance.task_week9.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val logTag: String? = HomeFragment::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    lateinit var adapter: HomeAdapter

    override fun setup() {
        val itemsList: MutableList<HomeItem<Any>> = mutableListOf()
        itemsList.add(
            HomeItem(
                item = DataSource.getStories(),
                type = HomeItemType.TYPE_STORIES,
            )
        )
        itemsList.addAll(
            DataSource.getPosts().map {
                HomeItem(
                    item = it,
                    type = HomeItemType.TYPE_POST,
                )
            }
        )
        adapter = HomeAdapter(itemsList)
        binding.recyclerHome.adapter = adapter
    }
}