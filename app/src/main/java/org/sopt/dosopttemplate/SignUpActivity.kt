package org.sopt.dosopttemplate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    private lateinit var nickName: String
    private lateinit var id: String
    private lateinit var pw: String
    private lateinit var mbti: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.signUpBtn.setOnClickListener {
            updateValues()
            validateAndGoToLogin()
        }
    }

    private fun updateValues() {
        nickName = binding.signUpEtNickName.text.toString()
        id = binding.signUpEtId.text.toString()
        pw = binding.signUpEtPw.text.toString()
        mbti = binding.signUpEtMbti.text.toString()
    }

    private fun checkCondition(): Boolean {
        if (nickName.isBlank()) {
            return false
        }
        if (id.length !in 6..10) {
            return false
        }
        if (pw.length !in 8..12) {
            return false
        }
        if (mbti.length != 4) {
            return false
        }
        return true
    }

    private fun nullCheck(): Boolean {
        if (nickName.isEmpty() || id.isEmpty() || pw.isEmpty() || mbti.isEmpty()) {
            Log.d("value", "${nickName}, ${id}, ${pw}, ${mbti}")
            Toast.makeText(this, "모든 정보를 입력해주세요!", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    private fun validateAndGoToLogin() {
        if (nullCheck()) {
            if (checkCondition()) {
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("nickName", nickName)
                    putExtra("id", id)
                    putExtra("password", pw)
                    putExtra("mbti", mbti)
                }
                setResult(RESULT_OK, intent)
                finish()
                Toast.makeText(this, "회원가입 성공했습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}