package com.example.stackoverflow.activity.detail.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.DisplayableItem
import com.example.domain.model.userDetail.UserItems
import kotlinx.android.synthetic.main.item_user_detail.view.*
import java.text.SimpleDateFormat
import java.util.*

class UserDetailItem(val items: UserItems) : DisplayableItem {
    override val itemType: Int
        get() = UserDetailAdapter.ITEM_USER_DETAIL

    override fun getKey(): String {
        return ""
    }
}

class UserDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun onBind(item: UserDetailItem) {
        itemView.tvReputationType.text = "Reputation Change: ${item.items.reputationChange}"
        itemView.tvChange.text = "Change: ${item.items.reputationChange}"
        itemView.tvCreatedAt.text = "Created At: ${convertLongToTime(item.items.creationDate)}"
        itemView.tvPostId.text = "Post ID: ${item.items.postId}"
    }
}

@SuppressLint("SimpleDateFormat")
fun convertLongToTime(time: Long?): String {
    val date = Date(time!!)
    val format = SimpleDateFormat("MM/dd/yyyy HH:mm")
    return format.format(date)
}

