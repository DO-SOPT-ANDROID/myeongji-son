package org.sopt.dosopttemplate.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showData()
    }

    private fun showData() = with(binding) {
        val nickName = intent.getStringExtra("nickName")
        val id = intent.getStringExtra("id")
        val mbti = intent.getStringExtra("mbti")

        mainTvNickName.text = nickName
        mainTvId.text = id
        mainTvMbti.text = mbti
    }
}