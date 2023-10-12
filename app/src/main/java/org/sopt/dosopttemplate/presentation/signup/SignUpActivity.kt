package org.sopt.dosopttemplate.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.login.LoginActivity
import org.sopt.dosopttemplate.util.showToast

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

        clickSignUpBtn()
    }

    private fun clickSignUpBtn() = with(binding) {
        signUpBtn.setOnClickListener {
            updateValues()
            validateAndGoToLogin()
        }
    }

    private fun updateValues() = with(binding) {
        nickName = signUpEtNickName.text.toString()
        id = signUpEtId.text.toString()
        pw = signUpEtPw.text.toString()
        mbti = signUpEtMbti.text.toString()
    }

    private fun checkCondition(): Boolean {
        if (nickName.isBlank() && id.length !in 6..10 && pw.length !in 8..12 && mbti.length != 4) {
            return false
        }
        return true
    }

    private fun nullCheck(): Boolean {
        if (nickName.isEmpty() || id.isEmpty() || pw.isEmpty() || mbti.isEmpty()) {
            Log.d("value", "${nickName}, ${id}, ${pw}, ${mbti}")
            Snackbar.make(
                binding.root,
                "모든 항목을 작성해주세요",
                Snackbar.LENGTH_SHORT
            ).show()
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
                showToast("회원가입 성공했습니다")
            }
        }
    }
}