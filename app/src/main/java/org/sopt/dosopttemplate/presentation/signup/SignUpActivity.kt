package org.sopt.dosopttemplate.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.login.LoginActivity
import org.sopt.dosopttemplate.util.showSnackBar
import org.sopt.dosopttemplate.util.showToast

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SingUpViewModel by viewModels()
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeData()
        clickSignUpBtn()
    }

    private fun observeData() = with(binding) {
        viewModel.nickName.observe(this@SignUpActivity) { value ->
            signUpEtNickName.setText(value)
        }
        viewModel.id.observe(this@SignUpActivity) { value ->
            signUpEtId.setText(value)
        }
        viewModel.pw.observe(this@SignUpActivity) { value ->
            signUpEtPw.setText(value)
        }
        viewModel.mbti.observe(this@SignUpActivity) { value ->
            signUpEtMbti.setText(value)
        }
    }

    private fun clickSignUpBtn() = with(binding) {
        signUpBtn.setOnClickListener {
            updateValues()
            validateInformation()
        }
    }

    private fun updateValues() = with(binding) {
        viewModel.nickName.value = signUpEtNickName.text.toString()
        viewModel.id.value = signUpEtId.text.toString()
        viewModel.pw.value = signUpEtPw.text.toString()
        viewModel.mbti.value = signUpEtMbti.text.toString()
    }

    private fun validateInformation() = with(binding) {
        val nickName = viewModel.nickName.value
        val id = viewModel.id.value
        val pw = viewModel.pw.value
        val mbti = viewModel.mbti.value

        if (nullCheck(nickName, id, pw, mbti)) {
            var isValid = true

            if (nickName?.isBlank() == true) {
                signUpLyNickName.error = getString(R.string.signUp_warning_nickName)
                isValid = false
            }

            if (id?.length !in 6..10) {
                signUpLyId.error = getString(R.string.signUp_warning_id)
                isValid = false
            }

            if (pw?.length !in 8..10) {
                signUpLyPw.error = getString(R.string.signUp_warning_pw)
                isValid = false
            }

            if (mbti?.length != 4) {
                signUpLyMbti.error = getString(R.string.signUp_warning_mbti)
                isValid = false
            }

            if (isValid) {
                navigateToLogin(nickName, id, pw, mbti)
            }
        }
    }

    private fun nullCheck(nickName: String?, id: String?, pw: String?, mbti: String?): Boolean {
        return if (nickName.isNullOrEmpty() || id.isNullOrEmpty() || pw.isNullOrEmpty() || mbti.isNullOrEmpty()) {
            binding.root.showSnackBar(getString(R.string.signup_warning_null))
            false
        } else {
            true
        }
    }

    private fun navigateToLogin(nickName: String?, id: String?, pw: String?, mbti: String?) {
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
