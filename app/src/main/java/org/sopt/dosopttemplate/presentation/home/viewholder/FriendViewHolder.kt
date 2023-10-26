package org.sopt.dosopttemplate.presentation.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.FriendList
import org.sopt.dosopttemplate.databinding.ItemFriendListBinding

class FriendViewHolder(private val binding: ItemFriendListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(friendData: FriendList) {
        binding.friendRVIvProfile.setImageResource(friendData.profileImage)
        binding.friendRVTvName.text = friendData.name
    }
}
