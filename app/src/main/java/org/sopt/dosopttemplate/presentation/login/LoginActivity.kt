package org.sopt.dosopttemplate.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.presentation.HomeActivity
import org.sopt.dosopttemplate.presentation.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private lateinit var loginId: String
    private lateinit var loginPw: String

    private lateinit var id: String
    private lateinit var pw: String
    private lateinit var nickName: String
    private lateinit var mbti: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickLoginBtn()

        initSignUpBtnClickListener()
    }

    private fun clickLoginBtn() {
        binding.loginButton.setOnClickListener {
            updateValues()
        }
    }

    private fun updateValues() {
        with(binding) {
            loginId = loginEtId.text.toString()
            loginPw = loginEtPw.text.toString()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        val sp = this.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        with(sp.edit()) {
            putString("nickName", nickName)
            putString("id", id)
            putString("mbti", mbti)
            commit()
        }

        startActivity(intent)
        finish()
    }

    private fun initSignUpBtnClickListener() = with(binding) {
        loginTvSingUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
