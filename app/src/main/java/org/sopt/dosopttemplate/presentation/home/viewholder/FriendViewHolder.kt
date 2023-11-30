package org.sopt.dosopttemplate.presentation.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.dosopttemplate.data.model.response.Data
import org.sopt.dosopttemplate.databinding.ItemFriendListBinding

class FriendViewHolder(private val binding: ItemFriendListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(userList: Data) {
        with(binding) {
            Glide.with(itemView.context)
                .load(userList.avatar)
                .into(ivFriendItemProfile)

            friendRVTvName.text = "${userList.first_name} ${userList.last_name}"
            friendRVTvEmail.text = userList.email
        }
    }
}
