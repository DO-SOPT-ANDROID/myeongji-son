package org.sopt.dosopttemplate.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.presentation.HomeActivity
import org.sopt.dosopttemplate.presentation.signup.SignUpActivity
import org.sopt.dosopttemplate.util.showToastShort

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel by viewModels<LoginViewModel>()

    private lateinit var loginId: String
    private lateinit var loginPw: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSignUpBtnClickListener()

        clickLoginBtn()

        observeLoginResult()
    }

    private fun clickLoginBtn() {
        binding.loginButton.setOnClickListener {
            updateValues()
            CoroutineScope(Dispatchers.IO).launch {
                loginUser(
                    loginId,
                    loginPw,
                )
            }
        }
    }

    private fun updateValues() {
        with(binding) {
            loginId = loginEtId.text.toString()
            loginPw = loginEtPw.text.toString()
        }
    }

    private suspend fun loginUser(loginId: String, loginPw: String) {
        loginViewModel.login(
            loginId,
            loginPw,
        )
    }

    private fun observeLoginResult() {
        lifecycleScope.launch {
            loginViewModel.loginState.collect { loginState ->
                when (loginState) {
                    is LoginState.Success -> {
                        showToastShort("로그인 성공")
                        startMainActivity()
                    }

                    is LoginState.Error -> {
                        showToastShort("로그인 실패")
                    }

                    is LoginState.Loading -> {
                        showToastShort("로그인 중")
                    }
                }
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, HomeActivity::class.java)
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
