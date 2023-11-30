package org.sopt.dosopttemplate.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.sopt.dosopttemplate.data.ApiManager
import org.sopt.dosopttemplate.data.api.UserService
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding
import org.sopt.dosopttemplate.presentation.home.adapter.FriendAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

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

        initUserData()
    }

    private fun initUserData() {
        viewLifecycleOwner.lifecycleScope.launch {
            val userService = ApiManager.createTest<UserService>()
            try {
                val response = userService.getUserList(2)
                if (response.isSuccessful) {
                    val response = response.body()?.data

                    response.let {
                        withContext(Dispatchers.Main) {
                            val adapter = it?.let { it1 -> FriendAdapter(it1) }
                            binding.rvFriend.adapter = adapter
                        }
                    }
                } else {
                    Log.d("hi", response.code().toString())
                }
            } catch (e: Exception) {
                Log.d("hi", e.toString())
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
