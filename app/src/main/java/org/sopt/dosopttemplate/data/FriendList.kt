package org.sopt.dosopttemplate.data

import androidx.annotation.DrawableRes

data class FriendList(
    @DrawableRes val profileImage: Int,
    val name: String,
    val statusMessage: String?,
)
