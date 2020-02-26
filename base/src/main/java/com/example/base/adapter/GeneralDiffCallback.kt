package com.example.base.adapter

import androidx.recyclerview.widget.DiffUtil
import javax.inject.Inject

class GeneralDiffCallback<I : DisplayableItem> @Inject constructor() : DiffUtil.ItemCallback<I>() {

    override fun areItemsTheSame(oldItem: I, newItem: I): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: I, newItem: I): Boolean =
        oldItem.getKey() == newItem.getKey()
}