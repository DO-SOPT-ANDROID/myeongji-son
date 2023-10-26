package org.sopt.dosopttemplate.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.data.FriendList
import org.sopt.dosopttemplate.data.MyProfile
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding
import org.sopt.dosopttemplate.presentation.home.adapter.FriendAdapter
import org.sopt.dosopttemplate.presentation.home.adapter.ProfileAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    private val mockFriendList = listOf(
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profileData = MyProfile(
            profileImage = R.drawable.img_suho,
            name = "손수호",
        )
        val profileAdapter = ProfileAdapter(requireContext()).apply {
            setMyProfile(profileData)
        }

        val friendAdapter = FriendAdapter(requireContext()).apply {
            setFriendList(mockFriendList)
        }

        val concatAdapter = ConcatAdapter(profileAdapter, friendAdapter)
        binding.rvFriend.adapter = concatAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
