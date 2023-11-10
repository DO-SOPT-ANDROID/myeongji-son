package org.sopt.dosopttemplate.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.Friend
import org.sopt.dosopttemplate.databinding.ItemFriendListBinding
import org.sopt.dosopttemplate.presentation.home.viewholder.FriendViewHolder

class FriendAdapter(context: Context) : RecyclerView.Adapter<FriendViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var friend: List<Friend> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = ItemFriendListBinding.inflate(inflater, parent, false)
        return FriendViewHolder(binding)
    }

    override fun getItemCount() = friend.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.onBind(friend[position])
    }

    fun setFriendList(friend: List<Friend>) {
        this.friend = friend.toList()
        notifyDataSetChanged()
    }
}
