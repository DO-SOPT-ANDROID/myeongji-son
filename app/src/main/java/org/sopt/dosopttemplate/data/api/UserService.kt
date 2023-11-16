package org.sopt.dosopttemplate.data.api

import org.sopt.dosopttemplate.data.model.response.ResponseUser
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("/api/users?page=2")
    suspend fun getUserList(): Response<ResponseUser>
}
