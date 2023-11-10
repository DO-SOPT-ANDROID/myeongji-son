package org.sopt.dosopttemplate.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding
import org.sopt.dosopttemplate.presentation.home.adapter.FriendAdapter
import org.sopt.dosopttemplate.presentation.home.adapter.MyProfileAdapter
import org.sopt.dosopttemplate.presentation.home.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    private val viewModel: HomeViewModel by viewModels()
    private var myProfileAdapter: MyProfileAdapter? = null
    private var friendAdapter: FriendAdapter? = null

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

        initAdapter()
    }

    private fun initAdapter() {
        myProfileAdapter = MyProfileAdapter(requireContext()).apply {
            setMyProfile(viewModel.profileData)
        }

        friendAdapter = FriendAdapter(requireContext()).apply {
            setFriendList(viewModel.mockFriends)
        }

        val concatAdapter = ConcatAdapter(myProfileAdapter, friendAdapter)
        binding.rvFriend.adapter = concatAdapter
    }

    override fun onDestroyView() {
        binding.rvFriend.adapter = null
        myProfileAdapter = null
        friendAdapter = null
        _binding = null
        super.onDestroyView()
    }
}
