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
    fun onBind(item: UserDetailItem) {
        itemView.tvReputationType.text = item.items.reputationChange.toString()
        itemView.tvChange.text = item.items.reputationChange.toString()
        itemView.tvCreatedAt.text = item.items.creationDate.toString()
        itemView.tvPostId.text = item.items.postId.toString()
    }
}

@SuppressLint("SimpleDateFormat")
fun convertLongToTime(time: Long?): String {
    val date = Date(time!!)
    val format = SimpleDateFormat("MM/dd/yyyy HH:mm")
    return format.format(date)
}

