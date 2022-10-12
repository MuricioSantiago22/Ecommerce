package com.example.e_commerce.core

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T> ( itemView : View):RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item:T)
}



