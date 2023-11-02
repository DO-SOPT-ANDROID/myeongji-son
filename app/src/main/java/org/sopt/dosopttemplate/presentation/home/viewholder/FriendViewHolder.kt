package org.sopt.dosopttemplate.presentation.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.Friend
import org.sopt.dosopttemplate.databinding.ItemFriendListBinding

class FriendViewHolder(private val binding: ItemFriendListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(friendData: Friend) = with(binding) {
        friendRVIvProfile.setImageResource(friendData.profileImage)
        friendRVTvName.text = friendData.name
        friendRVTvStatusMessage.text = friendData.statusMessage
    }
}
