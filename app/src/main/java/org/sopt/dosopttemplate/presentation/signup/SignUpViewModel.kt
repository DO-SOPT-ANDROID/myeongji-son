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
        isIdValid.value = id.value?.length in (ID_MIN_VALUE..ID_MAX_VALUE)
    }

    fun validatePwField() {
        isPwValid.value = pw.value?.length in (PW_MIN_VALUE..PW_MAX_VALUE)
    }

    fun validateMBTIField() {
        isMbtiValid.value = mbti.value?.length == MBTI_VALUE
    }

    companion object {
        const val ID_MIN_VALUE = 6
        const val ID_MAX_VALUE = 10
        const val PW_MIN_VALUE = 8
        const val PW_MAX_VALUE = 10
        const val MBTI_VALUE = 4
    }
}
