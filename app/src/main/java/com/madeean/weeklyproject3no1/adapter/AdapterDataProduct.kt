package com.madeean.weeklyproject3no1.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no1.R
import com.madeean.weeklyproject3no1.model.ProductModel
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.collections.ArrayList

class AdapterDataProduct(
    private var listData: ArrayList<ProductModel>,
    private var context: Context
) : RecyclerView.Adapter<AdapterDataProduct.MakananViewHolder>() {
    private lateinit var mlistener: OnItemClickListener

    interface OnItemClickListener {
        fun goToDetailProduct(position: Int, data: ProductModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mlistener = listener
    }


    class MakananViewHolder(
        ItemView: View,
        listener: OnItemClickListener,
        listData: ArrayList<ProductModel>
    ) : RecyclerView.ViewHolder(ItemView) {
        val ivProduct: ImageView = itemView.findViewById(R.id.iv_image)
        val tvNamaProduct: TextView = itemView.findViewById(R.id.tv_nama_product)
        val tvHargaProduct: TextView = itemView.findViewById(R.id.tv_harga_product)
        val tvDiskon: TextView = itemView.findViewById(R.id.tv_diskon)
        val tvHargaDiskon: TextView = itemView.findViewById(R.id.tv_harga_diskon_product)
        val tvStockFrom: TextView = itemView.findViewById(R.id.stok_from)
        private val rlProduct: RelativeLayout = itemView.findViewById(R.id.rl_product)

        init {
            rlProduct.setOnClickListener {
                listener.goToDetailProduct(adapterPosition, listData[adapterPosition])
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_data_makanan, parent, false)
        return MakananViewHolder(view, mlistener, listData)
    }

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
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
            var diskon = 0

            try {
                val hitungDiskon: Double = (hargaAsli - hargaDiskon) / hargaAsli.toDouble() * 100
                diskon = hitungDiskon.toInt()
            } catch (e: Exception) {
                e.printStackTrace()
            }

//            val diskon = ((listData[position].normalPrice - (listData[position].specialPrice
//                ?: 0)) / listData[position].normalPrice) * 100

            holder.tvDiskon.text = buildString {
                append(diskon)
                append("%")
            }
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
        when (listData[position].stockFrom) {
            "Toko" -> {
                //            set drawable start
                holder.tvStockFrom.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.stok_toko,
                    0,
                    0,
                    0
                )
            }
            "Gudang" -> {
                holder.tvStockFrom.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.stok_gudang,
                    0,
                    0,
                    0
                )
            }
            else -> {
                holder.tvStockFrom.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.stok_private_marketplace,
                    0,
                    0,
                    0
                )
            }
        }

        Glide.with(context)
            .load(listData[position].productImage[0])
            .into(holder.ivProduct)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}