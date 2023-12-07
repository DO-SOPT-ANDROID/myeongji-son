package org.sopt.dosopttemplate.presentation.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

    fun validateNicknameField() {
        isNickNameValid.value = !nickName.value.isNullOrBlank()
    }

    fun validateIdField() {
        isIdValid.value = id.value?.matches(ID_PATTERN.toRegex())
    }

    fun validatePwField() {
        isPwValid.value = pw.value?.matches(PW_PATTERN.toRegex())
    }

    fun validateMBTIField() {
        isMbtiValid.value = mbti.value?.length == MBTI_VALUE
    }

    companion object {
        const val ID_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$"
        const val PW_PATTERN =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[\$@\$!%*#?&])[A-Za-z\\d\$@\$!%*#?&]{6,12}\$"
        const val MBTI_VALUE = 4
    }
}
