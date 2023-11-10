package org.sopt.dosopttemplate.presentation.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SingUpViewModel : ViewModel() {

    val nickName = MutableLiveData<String>()
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val mbti = MutableLiveData<String>()
}
