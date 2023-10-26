package org.sopt.dosopttemplate.presentation.mypage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.databinding.ActivityMainBinding
import org.sopt.dosopttemplate.databinding.ActivityMyPageBinding

class MyPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
    }

    private fun initData() = with(binding) {
        val nickName = intent.getStringExtra("nickName")
        val id = intent.getStringExtra("id")
        val mbti = intent.getStringExtra("mbti")

        mainTvNickName.text = nickName
        mainTvId.text = id
        mainTvMbti.text = mbti
    }
}