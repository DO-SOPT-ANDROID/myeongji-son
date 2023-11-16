package org.sopt.dosopttemplate.data.api

import org.sopt.dosopttemplate.data.model.request.RequestSignUp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/members")
    suspend fun postSignUp(
        @Body request: RequestSignUp,
    ): Response<Unit>
}
