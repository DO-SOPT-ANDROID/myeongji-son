package org.sopt.dosopttemplate.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignIn(
    @SerialName("id")
    val id: Int,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("username")
    val username: String,
)
