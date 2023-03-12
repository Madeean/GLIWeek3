package com.madeean.weeklyproject3no2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.adapter.ProductAdapter
import com.madeean.weeklyproject3no2.database.MakananDatabase
import com.madeean.weeklyproject3no2.database.MinumanDatabase
import com.madeean.weeklyproject3no2.model.BannerModel
import com.madeean.weeklyproject3no2.model.ProductModel

class ProductSesuaiPromoActivity : AppCompatActivity() {
    private var banner: BannerModel? = null
    private val listData = arrayListOf<ProductModel>()
    private lateinit var rvProductSesuaiPromo: RecyclerView
    private lateinit var ivBannerProduct: ImageView
    private lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_sesuai_promo)

        rvProductSesuaiPromo = findViewById(R.id.rv_product_sesuai_promo)
        ivBannerProduct = findViewById(R.id.iv_banner_product)

        banner = intent.getParcelableExtra<BannerModel>(Utils.INTENT_BANNER_TO_PRODUCT)
        if (banner == null) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            return
        }

        when (banner?.namaPromo) {
            "Minuman Segar" -> showMinumanSegar()
            "Kebutuhan Dapur Bunda" -> showKebutuhanDapurBunda()
            "Snack" -> showSnack()
            else -> return
        }


    }

    private fun showSnack() {
        listData.addAll(
            listOf(
                MakananDatabase.makananDatabase6,
                MakananDatabase.makananDatabase7,
                MakananDatabase.makananDatabase8,
                MakananDatabase.makananDatabase9,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)
    }

    private fun showKebutuhanDapurBunda() {
        listData.addAll(
            listOf(
                MakananDatabase.makananDatabase1,
                MakananDatabase.makananDatabase2,
                MakananDatabase.makananDatabase3,
                MakananDatabase.makananDatabase4,
                MakananDatabase.makananDatabase5,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)
    }

    private fun showMinumanSegar() {
        listData.addAll(
            listOf(
                MinumanDatabase.minumanDatabase1,
                MinumanDatabase.minumanDatabase2,
                MinumanDatabase.minumanDatabase3,
                MinumanDatabase.minumanDatabase4,
                MinumanDatabase.minumanDatabase5,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)

    }

    private fun setAdapter(listData: ArrayList<ProductModel>) {
        rvProductSesuaiPromo.layoutManager = GridLayoutManager(this, 2)
        adapter = ProductAdapter(listData, this)
        rvProductSesuaiPromo.setHasFixedSize(true)
        rvProductSesuaiPromo.adapter = adapter
    }

}