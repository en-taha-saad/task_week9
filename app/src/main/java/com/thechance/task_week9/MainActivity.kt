package com.thechance.task_week9

import android.view.LayoutInflater

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG = MainActivity::class.simpleName

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun setup() {

    }

    override val logTag: String?
        get() = TODO("Not yet implemented")

}