package org.sopt.dosopttemplate.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.ApiManager
import org.sopt.dosopttemplate.data.api.AuthService
import org.sopt.dosopttemplate.data.model.request.RequestSignIn
import org.sopt.dosopttemplate.data.model.response.ResponseSignIn

class LoginViewModel : ViewModel() {

    private val _loginResult: MutableLiveData<ResponseSignIn> = MutableLiveData()
    val loginResult: LiveData<ResponseSignIn> = _loginResult

    private val _loginSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Loading)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    suspend fun login(id: String, pw: String) {
        viewModelScope.launch {
            val loginService = ApiManager.create<AuthService>()
            kotlin.runCatching {
                loginService.postSignIn(RequestSignIn(id, pw))
            }.onSuccess {
                val body = it.body()
                if (body != null) {
                    _loginState.value = LoginState.Success(body)
                } else {
                    _loginState.value = LoginState.Error
                }
                Log.d("server", body.toString())
            }.onFailure {
                _loginState.value = LoginState.Error
                Log.d("server", "아예실패")
            }
        }
    }
}
