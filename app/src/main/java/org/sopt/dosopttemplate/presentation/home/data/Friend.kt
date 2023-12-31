package org.sopt.dosopttemplate.presentation.home.data

import androidx.annotation.DrawableRes

data class Friend(
    @DrawableRes val profileImage: Int,
    val name: String,
    val statusMessage: String?,
)
