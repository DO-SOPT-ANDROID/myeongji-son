package org.sopt.dosopttemplate.presentation.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.presentation.HomeActivity
import org.sopt.dosopttemplate.presentation.signup.SignUpActivity
import org.sopt.dosopttemplate.util.showToast

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

        getUserDataFromSignUp()

        clickLoginBtn()

        initSignUpBtnClickListener()
    }

    private fun getUserDataFromSignUp() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val userData = result.data
                    id = userData?.getStringExtra("id") ?: ""
                    nickName = userData?.getStringExtra("nickName") ?: ""
                    pw = userData?.getStringExtra("password") ?: ""
                    mbti = userData?.getStringExtra("mbti") ?: ""
                }
            }
    }

    private fun clickLoginBtn() {
        binding.loginButton.setOnClickListener {
            updateValues()
            checkData()
        }
    }

    private fun updateValues() = with(binding) {
        loginId = loginEtId.text.toString()
        loginPw = binding.loginEtPw.text.toString()
    }

    private fun checkData() {
        if (::id.isInitialized && ::pw.isInitialized) {
            if (loginId == id && loginPw == pw) {
                startMainActivity()
                showToast("로그인에 성공했습니다.")
            } else {
                showToast("아이디 혹은 비밀번호가 잘못 입력됐습니다.")
            }
        } else {
            showToast("회원가입이 되어있지 않습니다.")
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
            resultLauncher.launch(intent)
        }
    }
}
