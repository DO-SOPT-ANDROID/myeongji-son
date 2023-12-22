package org.sopt.dosopttemplate.presentation.login

import org.sopt.dosopttemplate.data.model.response.ResponseSignIn

sealed class LoginState {
    data class Success(val userId: ResponseSignIn) : LoginState()
    object Loading : LoginState()
    object Error : LoginState()
}
