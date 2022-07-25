package com.thechance.task_week9

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.thechance.task_week9.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val homeFragment = HomeFragment()

    override val logTag = MainActivity::class.simpleName
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun setup() {

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.sub_view_container, fragment)
        transaction.commit()
    }

}