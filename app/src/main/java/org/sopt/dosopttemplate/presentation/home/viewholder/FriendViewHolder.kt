package org.sopt.dosopttemplate.presentation.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.presentation.home.data.Friend
import org.sopt.dosopttemplate.databinding.ItemFriendListBinding

class FriendViewHolder(private val binding: ItemFriendListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(friendData: Friend) {
        with(binding) {
            ivFriendItemProfile.setImageResource(friendData.profileImage)
            friendRVTvName.text = friendData.name
            friendRVTvEmail.text = friendData.statusMessage
        }
    }
}
