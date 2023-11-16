package org.sopt.dosopttemplate.presentation.mypage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {
    private var _binding: FragmentMyPageBinding? = null
    private val binding: FragmentMyPageBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState:
        Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        loadUserData()
    }

    private fun loadUserData() {
        val sp = activity?.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)

        binding.mainTvNickName.text = sp?.getString("nickName", "")
        binding.mainTvId.text = sp?.getString("id", "")
        binding.mainTvMbti.text = sp?.getString("mbti", "")
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
