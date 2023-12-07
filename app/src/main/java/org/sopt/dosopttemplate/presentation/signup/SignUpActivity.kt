package org.sopt.dosopttemplate.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.login.LoginActivity
import org.sopt.dosopttemplate.util.showToast

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTextWatchers()
        observeViewModel()
        clickSignUpBtn()
    }

    private fun setUpTextWatchers() {
        with(binding) {
            signUpEtNickName.addTextChangedListener {
                viewModel.nickName.value = it.toString()
                viewModel.validateNicknameField()
            }

            signUpEtId.addTextChangedListener {
                viewModel.id.value = it.toString()
                viewModel.validateIdField()
            }

            signUpEtPw.addTextChangedListener {
                viewModel.pw.value = it.toString()
                viewModel.validatePwField()
            }

            signUpEtMbti.addTextChangedListener {
                viewModel.mbti.value = it.toString()
                viewModel.validateMBTIField()
            }
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            isNickNameValid.observe(this@SignUpActivity) { isValid ->
                binding.signUpLyNickName.error =
                    if (isValid) null else getString(R.string.signUp_warning_nickName)
            }

            isIdValid.observe(this@SignUpActivity) { isValid ->
                binding.signUpLyId.error =
                    if (isValid) null else getString(R.string.signUp_warning_id)
            }

            isPwValid.observe(this@SignUpActivity) { isValid ->
                binding.signUpLyPw.error =
                    if (isValid) null else getString(R.string.signUp_warning_pw)
            }

            isMbtiValid.observe(this@SignUpActivity) { isValid ->
                binding.signUpLyMbti.error =
                    if (isValid) null else getString(R.string.signUp_warning_mbti)
            }
        }
    }

    private fun clickSignUpBtn() {
        binding.signUpBtn.setOnClickListener {
            viewModel.validateField()
            validateInformationCondition()
        }
    }

    private fun validateInformationCondition() {
        if (viewModel.isNickNameValid.value == true && viewModel.isIdValid.value == true && viewModel.isPwValid.value == true && viewModel.isMbtiValid.value == true) {
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
        showToast(getString(R.string.signUp_complete))
    }
}
