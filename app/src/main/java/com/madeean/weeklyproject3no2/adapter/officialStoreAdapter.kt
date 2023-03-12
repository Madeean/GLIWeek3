package com.madeean.weeklyproject3no2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.R
import com.madeean.weeklyproject3no2.model.StoreModel
import kotlin.collections.ArrayList

class OfficialStoreAdapter(
    private var listData: ArrayList<StoreModel>,
    private var context: Context
): RecyclerView.Adapter<OfficialStoreAdapter.OfficialStoreAdapterViewHolder>() {
    private lateinit var itemListener: OnItemClickListener
    interface OnItemClickListener {
        fun goToDetailStore(position: Int, data: StoreModel)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemListener = listener
    }

    class OfficialStoreAdapterViewHolder(itemView: View, listener: OfficialStoreAdapter.OnItemClickListener, listData: ArrayList<StoreModel>) : RecyclerView.ViewHolder(itemView) {
        val ivStore: ImageView = itemView.findViewById(R.id.iv_store_logo)
        val tvStore: TextView = itemView.findViewById(R.id.tv_nama_store)
        val cvStoreList: CardView = itemView.findViewById(R.id.cv_official_store)
        init {
            cvStoreList.setOnClickListener {
                listener.goToDetailStore(adapterPosition, listData[adapterPosition])
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficialStoreAdapterViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_official_store, parent, false)
        return  OfficialStoreAdapterViewHolder(view,itemListener,listData)
    }

    override fun onBindViewHolder(holder: OfficialStoreAdapterViewHolder, position: Int) {

        val storeData: StoreModel = listData[position]

        Glide.with(context).load(storeData.image).into(holder.ivStore)
        holder.tvStore.text = storeData.namaOfficialStore

    }

    override fun getItemCount(): Int {
        return listData.size
    }
}
