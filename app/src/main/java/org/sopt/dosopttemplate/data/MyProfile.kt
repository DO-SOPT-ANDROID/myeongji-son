package org.sopt.dosopttemplate.data

import androidx.annotation.DrawableRes

data class MyProfile(
    @DrawableRes val profileImage: Int,
    val name: String,
)
