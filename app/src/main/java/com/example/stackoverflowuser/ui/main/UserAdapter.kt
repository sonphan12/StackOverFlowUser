package com.example.stackoverflowuser.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stackoverflowuser.R
import kotlinx.android.synthetic.main.user_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserVH>() {

    var users: List<UserUiModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH = UserVH(
        LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
    )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = users[position]
        with(holder.itemView) {
            txtName.text = user.name
            txtReputationVal.text = user.reputation.toString()
            Glide.with(context).load(user.avatar).into(imgAvatar)
            txtLocation.text = user.location
            txtLastSeenVal.text = formatLastSeen(user.lastSeen)
            imgBookmark.setImageResource(
                if (user.isBookmarked) {
                    R.drawable.ic_bookmarked
                } else {
                    R.drawable.ic_bookmark
                }
            )
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun formatLastSeen(lastSeen: Long): String {
        val date = Date(lastSeen)
        val formatter = SimpleDateFormat("hh:mm:ss yyyy-mm-dd")
        return formatter.format(date)
    }

    class UserVH(v: View) : RecyclerView.ViewHolder(v)
}