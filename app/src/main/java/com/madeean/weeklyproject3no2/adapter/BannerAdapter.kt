package com.madeean.weeklyproject3no2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.ProductSesuaiPromoActivity
import com.madeean.weeklyproject3no2.R
import com.madeean.weeklyproject3no2.Utils
import com.madeean.weeklyproject3no2.model.BannerModel
import com.smarteist.autoimageslider.SliderViewAdapter

class BannerAdapter(
    private var listBanner: ArrayList<BannerModel>, var context: Context
) : SliderViewAdapter<BannerAdapter.BannerAdapterViewHolder>() {


    class BannerAdapterViewHolder(itemView: View) : ViewHolder(itemView) {
        var ivItemBanner: ImageView = itemView.findViewById(R.id.iv_item_banner)

    }

    override fun getCount(): Int {
        return listBanner.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): BannerAdapterViewHolder {
        val view: View =
            LayoutInflater.from(context)
                .inflate(R.layout.item_banner, parent, false)
        return BannerAdapterViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: BannerAdapterViewHolder, position: Int) {
        val bannerData: BannerModel = listBanner[position]

        Glide.with(context).load(bannerData.image).into(viewHolder.ivItemBanner)

        viewHolder.ivItemBanner.setOnClickListener {
            val intent = Intent(context, ProductSesuaiPromoActivity::class.java)
            intent.putExtra(Utils.INTENT_BANNER_TO_PRODUCT, bannerData)
            context.startActivity(intent)
        }
    }
}