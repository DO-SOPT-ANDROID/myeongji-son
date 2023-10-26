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
            statusMessage = "츄르 공구 할 사람",
        ),
        FriendList(
            profileImage = R.drawable.img_dog,
            name = "박강쥐",
            statusMessage = "",
        ),
        FriendList(
            profileImage = R.drawable.img_otter,
            name = "이해달",
            statusMessage = "",
        ),
        FriendList(
            profileImage = R.drawable.img_penguin,
            name = "최펭귄",
            statusMessage = "날씨가 요새 더워",
        ),
        FriendList(
            profileImage = R.drawable.img_red_panda,
            name = "정판다",
            statusMessage = "푸바오 돈 많이 벌더라",
        ),
        FriendList(
            profileImage = R.drawable.img_rabbit,
            name = "손토끼",
            statusMessage = "",
        ),
        FriendList(
            profileImage = R.drawable.img_squirrel,
            name = "지다람",
            statusMessage = "외국에선 다람지",
        ),
        FriendList(
            profileImage = R.drawable.img_lion,
            name = "나심바",
            statusMessage = "I'm a King",
        ),
        FriendList(
            profileImage = R.drawable.img_mouse,
            name = "나따뚜이",
            statusMessage = "",
        ),
    )

    val profileData = MyProfile(
        profileImage = R.drawable.img_suho,
        name = "손수호",
    )
}
