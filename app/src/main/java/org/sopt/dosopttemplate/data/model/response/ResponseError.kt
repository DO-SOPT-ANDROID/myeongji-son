package org.sopt.dosopttemplate.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class ResponseError(
    @SerialName("message")
    val message: String,
) {
    companion object {
        fun parseErrorResponse(errorBody: String?): ResponseError? {
            if (errorBody != null) {
                return Json.decodeFromString<ResponseError>(errorBody)
            }
            return null
        }
    }
}
