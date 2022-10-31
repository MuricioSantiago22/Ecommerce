package com.example.e_commerce.ui.productsList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerce.core.BaseViewHolder
import com.example.e_commerce.data.model.Product
import com.example.e_commerce.databinding.ItemProductListBinding


class ProductListAdapter(
    private val listProduct: List<Product>,
    private val itemClickListener: OnProductListClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnProductListClickListener {
        fun onProductListClick(product: Product)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ProductListViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onProductListClick(listProduct[position])
        }
        return holder



    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ProductListViewHolder -> holder.bind(listProduct[position])
        }
    }

    override fun getItemCount(): Int = listProduct.size


    private inner class ProductListViewHolder(
        val binding: ItemProductListBinding, val context: Context
    ) : BaseViewHolder<Product>(binding.root) {
        override fun bind(item: Product) {
            val imageUrl = item.imageUrl
            Glide.with(context).load(imageUrl)
                .centerCrop().into(binding.itemImage)
            binding.itemName.text = item.title
            binding.ItemShortDescription.text = item.shortDescription
            binding.ItemPrice.text = "$${item.price}"
            binding.itemDescount.text = "-$${item.discount}"
        }

    }


}