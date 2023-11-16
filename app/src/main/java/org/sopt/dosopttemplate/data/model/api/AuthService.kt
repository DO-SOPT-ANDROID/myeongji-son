package org.sopt.dosopttemplate.data.model.api

import org.sopt.dosopttemplate.data.model.request.RequestSignUp
import org.sopt.dosopttemplate.data.model.response.ResponseSignUp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/members")
    suspend fun postSignUp(
        @Body request: RequestSignUp,
    ): Response<ResponseSignUp>
}
