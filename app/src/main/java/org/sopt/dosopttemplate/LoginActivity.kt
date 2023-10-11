package org.sopt.dosopttemplate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private lateinit var loginId: String
    private lateinit var loginPw: String

    private lateinit var id: String
    private lateinit var pw: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val userData = result.data
                    id = userData?.getStringExtra("id") ?: ""
                    val nickName = userData?.getStringExtra("nickName") ?: ""
                    pw = userData?.getStringExtra("password") ?: ""
                    val mbti = userData?.getStringExtra("mbti") ?: ""

                    Log.d("userData", "${id},${nickName},${pw}, ${mbti}")
                }
            }

        binding.loginButton.setOnClickListener {
            updateValues()
            checkData()
        }

        goSignUp()
    }

    private fun checkData() {
        if (loginId == id && loginPw == pw) {
            goMain()
        } else {
            Toast.makeText(this, "아이디 혹은 비밀번호가 잘못 입력됐습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateValues() = with(binding) {
        loginId = loginEtId.text.toString()
        loginPw = binding.loginEtPw.text.toString()
    }

    private fun goMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goSignUp() = with(binding) {
        loginTvSingUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            resultLauncher.launch(intent)
            Toast.makeText(this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
        }
    }
}