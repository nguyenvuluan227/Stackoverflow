package com.example.stackoverflow.activity.main.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.DisplayableItem
import com.example.domain.model.userList.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user_list.view.*
import java.text.SimpleDateFormat
import java.util.*

class UserItem(val item: Item) : DisplayableItem {
    override val itemType: Int
        get() = UserListAdapter.ITEM_USER

    override fun getKey(): String {
        return ""
    }
}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun onBind(item: UserItem, onItemCLicked: ((userId: Int) -> Unit)? = null) {
        itemView.tvUserName.text = item.item.displayName
        itemView.tvReputation.text = item.item.reputation.toString()
        if (item.item.location == null)
            itemView.tvLocation.text = "Unknown location"
        else
            itemView.tvLocation.text = item.item.location
        itemView.tvLastAccessDate.text = convertLongToTime(item.item.lastAccessDate)
        Picasso.get().load(item.item.profileImage)
            .into(itemView.imvUserAvatar)

        itemView.setOnClickListener { onItemCLicked?.invoke(item.item.userId!!) }
    }

    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time: Long?): String {
        val date = Date(time!!)
        val format = SimpleDateFormat("MM/dd/yyyy HH:mm")
        return format.format(date)
    }
}