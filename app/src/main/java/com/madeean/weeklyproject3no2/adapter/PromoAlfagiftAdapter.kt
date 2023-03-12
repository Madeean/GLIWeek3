package com.madeean.weeklyproject3no2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.R
import com.madeean.weeklyproject3no2.model.BannerModel

class PromoAlfagiftAdapter(
    private val listBanner: ArrayList<BannerModel>,
    val context: Context
) : RecyclerView.Adapter<PromoAlfagiftAdapter.PromoAlfagiftViewHolder>() {

    private lateinit var mlistener: OnItemClickListener

    interface OnItemClickListener {
        fun goToProduct(position: Int, data: BannerModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mlistener = listener
    }


    class PromoAlfagiftViewHolder(ItemView: View,listener: OnItemClickListener, listBanner: ArrayList<BannerModel>) : RecyclerView.ViewHolder(ItemView) {
        val ivItemPromoAlfagift: ImageView = itemView.findViewById(R.id.iv_item_promo_alfagift)
        init {
            ivItemPromoAlfagift.setOnClickListener {
                listener.goToProduct(adapterPosition, listBanner[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoAlfagiftViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_promo_alfagift, parent, false)
        return PromoAlfagiftViewHolder(view, mlistener, listBanner)
    }

    override fun onBindViewHolder(holder: PromoAlfagiftViewHolder, position: Int) {
        val bannerData: BannerModel = listBanner[position]

        Glide.with(context).load(bannerData.image).into(holder.ivItemPromoAlfagift)
    }

    override fun getItemCount(): Int {
        return listBanner.size
    }


}