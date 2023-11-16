package org.sopt.dosopttemplate.data.api

import org.sopt.dosopttemplate.data.model.request.RequestSignIn
import org.sopt.dosopttemplate.data.model.request.RequestSignUp
import org.sopt.dosopttemplate.data.model.response.ResponseSignIn
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/members")
    suspend fun postSignUp(
        @Body request: RequestSignUp,
    ): Response<Unit>

    @POST("api/v1/members/sign-in")
    suspend fun postSignIn(
        @Body request: RequestSignIn,
    ): Response<ResponseSignIn>
}
