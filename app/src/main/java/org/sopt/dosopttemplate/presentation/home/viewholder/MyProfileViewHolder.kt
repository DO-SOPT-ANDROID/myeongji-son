package org.sopt.dosopttemplate.presentation.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.MyProfile
import org.sopt.dosopttemplate.databinding.ItemMyProfileBinding

class MyProfileViewHolder(private val binding: ItemMyProfileBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(profileData: MyProfile) {
        binding.homeIvMyProfile.setImageResource(profileData.profileImage)
        binding.homeTvMyName.text = profileData.name
    }
}
