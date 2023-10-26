package org.sopt.dosopttemplate.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.databinding.ActivityHomeBinding
import org.sopt.dosopttemplate.presentation.home.HomeFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addHomeFragment()
    }

    private fun addHomeFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home, HomeFragment())
                .commit()
        }
    }
}