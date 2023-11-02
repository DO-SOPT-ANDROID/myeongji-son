package org.sopt.dosopttemplate.presentation.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.Friend
import org.sopt.dosopttemplate.databinding.ItemFriendListBinding

class FriendViewHolder(private val binding: ItemFriendListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(friendData: Friend) {
        binding.friendRVIvProfile.setImageResource(friendData.profileImage)
        binding.friendRVTvName.text = friendData.name
        binding.friendRVTvStatusMessage.text = friendData.statusMessage
    }
}
