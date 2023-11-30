package org.sopt.dosopttemplate.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.ApiManager
import org.sopt.dosopttemplate.data.api.AuthService
import org.sopt.dosopttemplate.data.model.request.RequestSignIn
import org.sopt.dosopttemplate.data.model.response.ResponseError
import org.sopt.dosopttemplate.data.model.response.ResponseSignIn

class LoginViewModel : ViewModel() {

    private val _loginResult: MutableLiveData<ResponseSignIn> = MutableLiveData()
    val loginResult: LiveData<ResponseSignIn> = _loginResult

    private val _loginSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    suspend fun login(id: String, pw: String) {
        viewModelScope.launch {
            val loginService = ApiManager.create<AuthService>()
            try {
                val response = loginService.postSignIn(RequestSignIn(id, pw))

                if (response.isSuccessful) {
                    _loginResult.value = response.body()
                    _loginSuccess.value = true
                } else {
                    val errorBody = response.errorBody()?.string()
                    val errorResponse = ResponseError.parseErrorResponse(errorBody)
                    val errorMessage = errorResponse?.message
                    Log.d("signup", errorMessage.toString())
                    _loginSuccess.value = false
                }
            } catch (e: Exception) {
                Log.e("signup", "Failed to register user", e)
            }
        }
    }
}
