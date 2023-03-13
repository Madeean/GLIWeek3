package com.madeean.weeklyproject3no2.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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
) : RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {
    private fun formatter(n: Long) =
        DecimalFormat("#,###", DecimalFormatSymbols(Locale.GERMANY)).format(n)

    private lateinit var itemListener: OnItemClickListener

    interface OnItemClickListener {
        fun goToDetailProduct(position: Int, data: ProductModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemListener = listener
    }

    class ProductAdapterViewHolder(
        itemView: View,
        listener: OnItemClickListener,
        listData: ArrayList<ProductModel>
    ) : RecyclerView.ViewHolder(itemView) {
        val ivProduct: ImageView = itemView.findViewById(R.id.iv_image)
        val tvNamaProduct: TextView = itemView.findViewById(R.id.tv_nama_product)
        val tvHargaProduct: TextView = itemView.findViewById(R.id.tv_harga_product)
        val tvDiskon: TextView = itemView.findViewById(R.id.tv_diskon)
        val tvHargaDiskon: TextView = itemView.findViewById(R.id.tv_harga_diskon_product)
        val tvStockFrom: TextView = itemView.findViewById(R.id.stok_from)
        private val cvProdukPenawaran: CardView = itemView.findViewById(R.id.cv_produkList)

        init {
            cvProdukPenawaran.setOnClickListener {
                listener.goToDetailProduct(adapterPosition, listData[adapterPosition])
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        return ProductAdapterViewHolder(view, itemListener, listData)
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {

        holder.tvNamaProduct.text = listData[position].productName

        if (listData[position].stock <= 0) {
            holder.tvHargaProduct.text = context.getString(R.string.stok_habis)
            holder.tvHargaDiskon.visibility = View.INVISIBLE
            holder.tvDiskon.visibility = View.INVISIBLE

            showTvStockFrom(holder, position)

            showImageProduct(holder, position)
            return
        }

        if (listData[position].specialPrice == null) {
            showSpesialPriceNull(holder, position)
            return
        }

//        holder.tvHargaProduct.text = listData[position].normalPrice.toString()

        if ((listData[position].specialPrice
                ?: 0) < listData[position].normalPrice
        ) {
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

        showTvStockFrom(holder, position)
        showImageProduct(holder, position)
    }

    private fun showImageProduct(holder: ProductAdapterViewHolder, position: Int) {
        Glide.with(context)
            .load(listData[position].productImage[0])
            .into(holder.ivProduct)
    }

    private fun showSpesialPriceNull(holder: ProductAdapterViewHolder, position: Int) {
        holder.tvHargaDiskon.visibility = View.INVISIBLE
        holder.tvDiskon.visibility = View.INVISIBLE
        holder.tvHargaProduct.text =
            context.getString(
                R.string.format_harga, formatter(
                    listData[position].normalPrice
                )
            )

        showTvStockFrom(holder, position)
        showImageProduct(holder, position)
    }

    private fun showTvStockFrom(holder: ProductAdapterViewHolder, position: Int) {
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
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}
