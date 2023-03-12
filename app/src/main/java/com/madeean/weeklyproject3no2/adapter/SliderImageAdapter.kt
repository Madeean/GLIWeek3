package com.madeean.weeklyproject3no2.adapter

import com.madeean.weeklyproject3no2.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter


 class SliderImageAdapter(private var listImage: ArrayList<String>, var context: Context) :
    SliderViewAdapter<SliderImageAdapter.SliderImageAdapterViewHolder>() {


    class SliderImageAdapterViewHolder(itemView: View) : ViewHolder(itemView) {
        var ivImage: ImageView = itemView.findViewById(R.id.iv_image_slider)

    }

    override fun getCount(): Int {
        return listImage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderImageAdapterViewHolder {
        val view: View =
            LayoutInflater.from(context)
                .inflate(R.layout.item_data_image_slider, parent, false)
        return SliderImageAdapterViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderImageAdapterViewHolder, position: Int) {
        val sliderData: String = listImage[position]

        Glide.with(context).load(sliderData).into(viewHolder.ivImage)

    }
}