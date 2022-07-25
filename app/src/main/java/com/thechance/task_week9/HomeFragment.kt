package com.thechance.task_week9

import android.view.LayoutInflater
import com.thechance.task_week9.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val logTag: String? = HomeFragment::class.java.simpleName
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate


    lateinit var adapter: HomeAdapter

    override fun setup() {
        val itemsList: MutableList<HomeItem<Any>> = mutableListOf()
        itemsList.addAll(
            DataSource.getPosts().map { it.toHomeItem() }
        )
        adapter = HomeAdapter(itemsList)
        binding.recyclerHome.adapter = adapter
    }
}