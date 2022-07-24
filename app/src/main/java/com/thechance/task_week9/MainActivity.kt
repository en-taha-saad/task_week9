package com.thechance.task_week9

import android.view.LayoutInflater
import com.thechance.task_week9.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val logTag = MainActivity::class.simpleName
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun setup() {

    }


}