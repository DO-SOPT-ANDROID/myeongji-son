package org.sopt.dosopttemplate.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.data.ApiManager
import org.sopt.dosopttemplate.data.api.AuthService
import org.sopt.dosopttemplate.data.model.request.RequestSignIn
import org.sopt.dosopttemplate.data.model.response.ResponseError
import org.sopt.dosopttemplate.data.model.response.ResponseSignIn
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.presentation.HomeActivity
import org.sopt.dosopttemplate.presentation.signup.SignUpActivity
import org.sopt.dosopttemplate.util.showToastLong
import org.sopt.dosopttemplate.util.showToastShort

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var loginId: String
    private lateinit var loginPw: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSignUpBtnClickListener()

        clickLoginBtn()
    }

    private fun clickLoginBtn() {
        binding.loginButton.setOnClickListener {
            updateValues()
            loginUser(loginId, loginPw)
        }
    }

    private fun updateValues() {
        with(binding) {
            loginId = loginEtId.text.toString()
            loginPw = loginEtPw.text.toString()
        }
    }

    private fun loginUser(id: String, pw: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val loginService = ApiManager.create<AuthService>()
            try {
                val response = loginService.postSignIn(RequestSignIn(id, pw))
                if (response.isSuccessful) {
                    val responseData: ResponseSignIn? = response.body()
                    val responseId = responseData?.id
                    withContext(Dispatchers.Main) {
                        showToastLong(getString(R.string.success_login).format(responseId))
                    }
                    startMainActivity()
                } else {
                    val errorBody = response.errorBody()?.string()
                    val errorResponse = ResponseError.parseErrorResponse(errorBody)
                    val errorMessage = errorResponse?.message
                    withContext(Dispatchers.Main) {
                        if (errorMessage != null) {
                            showToastShort(errorMessage)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("signup", "Failed to register user", e)
                withContext(Dispatchers.Main) {
                    showToastShort(getString(R.string.all_unexpected_error_message))
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
