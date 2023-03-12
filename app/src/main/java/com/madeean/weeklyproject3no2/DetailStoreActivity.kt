package com.madeean.weeklyproject3no2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.adapter.ProductAdapter
import com.madeean.weeklyproject3no2.database.MakananDatabase
import com.madeean.weeklyproject3no2.model.BannerModel
import com.madeean.weeklyproject3no2.model.ProductModel
import com.madeean.weeklyproject3no2.model.StoreModel

class DetailStoreActivity : AppCompatActivity() {
    private lateinit var tvStoreName: TextView
    private lateinit var ivLogoStore: ImageView
    private lateinit var rvStoreProduct:RecyclerView
    private val listData = arrayListOf<ProductModel>()
    private var store: StoreModel? = null
    private lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_store)

        tvStoreName = findViewById(R.id.tv_store_name_detail)
        ivLogoStore = findViewById(R.id.iv_logo_detail)

        store = intent.getParcelableExtra<StoreModel>(Utils.INTENT_STORE_DETAIL)
        if (store == null) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            return
        }
        when (store?.namaOfficialStore) {
            "UNILIVER" -> showABC()
            else -> return
        }

    }
    private fun showABC() {
        listData.addAll(
            listOf(
                MakananDatabase.makananDatabase1,
                MakananDatabase.makananDatabase2,
                MakananDatabase.makananDatabase3,
                MakananDatabase.makananDatabase4,
                MakananDatabase.makananDatabase5,
                MakananDatabase.makananDatabase1,
                MakananDatabase.makananDatabase2,
                MakananDatabase.makananDatabase3,
                MakananDatabase.makananDatabase4,
                MakananDatabase.makananDatabase5
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun setAdapter(listData: ArrayList<ProductModel>) {
        rvStoreProduct.layoutManager = GridLayoutManager(this, 2)
        adapter = ProductAdapter(listData, this)
        rvStoreProduct.setHasFixedSize(true)
        rvStoreProduct.adapter = adapter
    }
}