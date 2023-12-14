package org.sopt.dosopttemplate.presentation.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class SignUpViewModel : ViewModel() {

    val nickName = MutableLiveData<String>()
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val mbti = MutableLiveData<String>()

    val isNickNameValid = MutableLiveData<Boolean>()
    val isIdValid = MutableLiveData<Boolean>()
    val isPwValid = MutableLiveData<Boolean>()
    val isMbtiValid = MutableLiveData<Boolean>()

    fun validateField() {
        validateIdField()
        validatePwField()
        validateMBTIField()
        validateNicknameField()
    }

    fun isAllFieldsValid(): Boolean {
        return isNickNameValid.value == true && isIdValid.value == true && isPwValid.value == true && isMbtiValid.value == true
    }

    fun validateNicknameField() {
        isNickNameValid.value = !nickName.value.isNullOrBlank()
    }

    fun validateIdField() {
        isIdValid.value = id.value?.let { ID_REGEX.matcher(it).matches() } ?: false
    }

    fun validatePwField() {
        isPwValid.value = pw.value?.let { PW_REGEX.matcher(it).matches() } ?: false
    }

    fun validateMBTIField() {
        isMbtiValid.value = mbti.value?.let { MBTI_REGEX.matcher(it).matches() } ?: false
    }

    companion object {
        private const val ID_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$"
        val ID_REGEX: Pattern = Pattern.compile(ID_PATTERN)
        private const val PW_PATTERN =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[\$@\$!%*#?&])[A-Za-z\\d\$@\$!%*#?&]{6,12}\$"
        val PW_REGEX: Pattern = Pattern.compile(PW_PATTERN)
        private const val MBTI_PATTERN = "^[a-zA-Z]{4}\$"
        val MBTI_REGEX: Pattern = Pattern.compile(MBTI_PATTERN)
    }
}
