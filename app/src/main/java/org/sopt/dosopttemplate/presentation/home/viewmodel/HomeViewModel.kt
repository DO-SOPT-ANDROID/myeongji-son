package org.sopt.dosopttemplate.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.data.FriendList
import org.sopt.dosopttemplate.data.MyProfile

class HomeViewModel : ViewModel() {
    val mockFriendList = listOf(
        FriendList(
            profileImage = R.drawable.img_cat,
            name = "김고양",
        ),
        FriendList(
            profileImage = R.drawable.img_dog,
            name = "박강쥐",
        ),
        FriendList(
            profileImage = R.drawable.img_otter,
            name = "이해달",
        ),
        FriendList(
            profileImage = R.drawable.img_penguin,
            name = "최펭귄",
        ),
        FriendList(
            profileImage = R.drawable.img_red_panda,
            name = "정판다",
        ),
        FriendList(
            profileImage = R.drawable.img_rabbit,
            name = "손토끼",
        ),
        FriendList(
            profileImage = R.drawable.img_squirrel,
            name = "지다람",
        ),
        FriendList(
            profileImage = R.drawable.img_lion,
            name = "나심바",
        ),
        FriendList(
            profileImage = R.drawable.img_mouse,
            name = "나따뚜이",
        ),
    )

    val profileData = MyProfile(
        profileImage = R.drawable.img_suho,
        name = "손수호",
    )
}
