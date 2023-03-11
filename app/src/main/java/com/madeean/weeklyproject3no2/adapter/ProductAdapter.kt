package com.madeean.weeklyproject3no2.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.R
import com.madeean.weeklyproject3no2.model.ProductModel
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.collections.ArrayList

class ProductAdapter(
    private var listData: ArrayList<ProductModel>,
    private var context: Context
): RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {
    class ProductAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProduct: ImageView = itemView.findViewById(R.id.iv_image)
        val tvNamaProduct: TextView = itemView.findViewById(R.id.tv_nama_product)
        val tvHargaProduct: TextView = itemView.findViewById(R.id.tv_harga_product)
        val tvDiskon: TextView = itemView.findViewById(R.id.tv_diskon)
        val tvHargaDiskon: TextView = itemView.findViewById(R.id.tv_harga_diskon_product)
        val tvStockFrom: TextView = itemView.findViewById(R.id.stok_from)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        return ProductAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        fun formatter(n: Long) =
            DecimalFormat("#,###", DecimalFormatSymbols(Locale.GERMANY)).format(n)

        holder.tvNamaProduct.text = listData[position].productName
//        holder.tvHargaProduct.text = listData[position].normalPrice.toString()
        if ((listData[position].specialPrice ?: 0) < listData[position].normalPrice) {
            holder.tvHargaDiskon.text =
                context.getString(R.string.format_harga, formatter(listData[position].normalPrice))
            holder.tvHargaDiskon.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

            holder.tvHargaProduct.text =
                context.getString(
                    R.string.format_harga, formatter(
                        listData[position].specialPrice
                            ?: 0
                    )
                )


            val hargaAsli = listData[position].normalPrice
            val hargaDiskon = listData[position].specialPrice ?: 0
            var finalDiskon: Int = 0

            try {
                val hitungDiskon: Double = (hargaAsli - hargaDiskon) / hargaAsli.toDouble() * 100
                finalDiskon = hitungDiskon.toInt()
            } catch (e: Exception) {
                e.printStackTrace()
            }

//            val diskon = ((listData[position].normalPrice - (listData[position].specialPrice
//                ?: 0)) / listData[position].normalPrice) * 100

            holder.tvDiskon.text = "$finalDiskon%"
        } else {
            holder.tvHargaDiskon.visibility = View.INVISIBLE
            holder.tvDiskon.visibility = View.INVISIBLE
        }

        holder.tvHargaProduct.text =
            context.getString(
                R.string.format_harga, formatter(
                    listData[position].specialPrice
                        ?: 0
                )
            )

        holder.tvStockFrom.text =
            context.getString(R.string.stok_from, listData[position].stockFrom)
        if (listData[position].stockFrom == "Toko") {
//            set drawable start
            holder.tvStockFrom.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.stok_toko,
                0,
                0,
                0
            )
        } else if (listData[position].stockFrom == "Gudang") {
            holder.tvStockFrom.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.stok_gudang,
                0,
                0,
                0
            )
        } else {
            holder.tvStockFrom.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.stok_private_marketplace,
                0,
                0,
                0
            )
        }

        Glide.with(context)
            .load(listData[position].productImage[0])
            .into(holder.ivProduct)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}
