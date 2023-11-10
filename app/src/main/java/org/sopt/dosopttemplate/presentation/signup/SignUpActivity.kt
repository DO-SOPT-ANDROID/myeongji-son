package org.sopt.dosopttemplate.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.login.LoginActivity
import org.sopt.dosopttemplate.util.showToast

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SingUpViewModel by viewModels()
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTextWatchers()
        clickSignUpBtn()
    }

    private fun setUpTextWatchers() = with(binding) {
        signUpEtNickName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank()) {
                    signUpLyNickName.error = getString(R.string.signUp_warning_nickName)
                } else {
                    signUpLyNickName.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.signUpEtId.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if ((s == null) || (s.length !in (6..10))) {
                    signUpLyId.error = getString(R.string.signUp_warning_id)
                } else {
                    signUpLyId.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        signUpEtPw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if ((s == null) || (s.length !in (8..10))) {
                    signUpLyPw.error = getString(R.string.signUp_warning_pw)
                } else {
                    signUpLyPw.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        signUpEtMbti.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if ((s == null) || (s.length != 4)) {
                    signUpLyMbti.error = getString(R.string.signUp_warning_mbti)
                } else {
                    signUpLyMbti.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
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
        if (signUpLyNickName.error == null && signUpLyId.error == null && signUpLyPw.error == null && signUpLyMbti.error == null) {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java).apply {
            putExtra("nickName", viewModel.nickName.value)
            putExtra("id", viewModel.id.value)
            putExtra("password", viewModel.pw.value)
            putExtra("mbti", viewModel.mbti.value)
        }
        setResult(RESULT_OK, intent)
        finish()
        showToast(getString(R.string.signUp_compleate))
    }
}

// 추후에 추가할 ... 코드
//    private fun observeData() = with(binding) {
//        viewModel.nickName.observe(this@SignUpActivity) { value ->
//            if (value.isBlank()) {
//                binding.signUpLyNickName.error = getString(R.string.signUp_warning_nickName)
//            } else {
//                binding.signUpLyNickName.error = null
//            }
//        }
//        viewModel.id.observe(this@SignUpActivity) { value ->
//            if (value.length !in 6..10) {
//                binding.signUpLyId.error = getString(R.string.signUp_warning_id)
//            } else {
//                binding.signUpLyId.error = null
//            }
//        }
//        viewModel.pw.observe(this@SignUpActivity) { value ->
//            if (value.length !in 8..10) {
//                binding.signUpLyPw.error = getString(R.string.signUp_warning_pw)
//            } else {
//                binding.signUpLyPw.error = null
//            }
//        }
//        viewModel.mbti.observe(this@SignUpActivity) { value ->
//            if (value.length != 4) {
//                binding.signUpLyMbti.error = getString(R.string.signUp_warning_mbti)
//            } else {
//                binding.signUpLyMbti.error = null
//            }
//        }
//    }
