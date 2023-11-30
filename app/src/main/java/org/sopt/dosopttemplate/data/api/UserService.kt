package org.sopt.dosopttemplate.data.api

import org.sopt.dosopttemplate.data.model.response.ResponseUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("/api/users")
    suspend fun getUserList(@Query("page") page: Int): Response<ResponseUser>
}