package org.sopt.dosopttemplate.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignIn(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
)