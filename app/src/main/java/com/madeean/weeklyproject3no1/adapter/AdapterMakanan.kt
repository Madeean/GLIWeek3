package com.madeean.weeklyproject3no1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.madeean.weeklyproject3no1.R
import com.madeean.weeklyproject3no1.model.ProductModel

class AdapterMakanan(
    private var listData: ArrayList<ProductModel>
) : RecyclerView.Adapter<AdapterMakanan.MakananViewHolder>() {
    class MakananViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivProduct:ImageView = itemView.findViewById(R.id.iv_image)
        val tvNamaProduct: TextView = itemView.findViewById(R.id.tv_nama_product)
        val tvHargaProduct:TextView = itemView.findViewById(R.id.tv_harga_product)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_data_makanan, parent, false)
        return MakananViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        holder.tvNamaProduct.text = listData[position].productName
        holder.tvHargaProduct.text = listData[position].normalPrice.toString()
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}