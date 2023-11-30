package org.sopt.dosopttemplate.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.model.response.Data
import org.sopt.dosopttemplate.databinding.ItemFriendListBinding
import org.sopt.dosopttemplate.presentation.home.viewholder.FriendViewHolder

class FriendAdapter(private val userList: List<Data>) : RecyclerView.Adapter<FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding =
            ItemFriendListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
