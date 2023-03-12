package com.madeean.weeklyproject3no2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.adapter.ProductAdapter
import com.madeean.weeklyproject3no2.database.*
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
        init()
        getData()
        setData()

    }

    private fun setData() {
        when (banner?.namaPromo) {
            "Minuman Segar" -> showMinumanSegar()
            "Kebutuhan Dapur Bunda" -> showKebutuhanDapurBunda()
            "Snack" -> showSnack()
            "Diapers" -> showDiapers()
            "Home Care" -> showHomeCare()
            "Susu Hebat" -> showSusuHebat()
            "Sanitary Napkin" -> showSanitaryNapkin()
            "Serba 5 ribuan" -> showSerba5ribuan()
            "Serba 10 ribuan" -> showSerba10ribuan()
            "Serba 17 ribuan" -> showSerba17ribuan()
            else -> return
        }
    }

    private fun getData() {
        banner = intent.getParcelableExtra<BannerModel>(Utils.INTENT_BANNER_TO_PRODUCT)
        if (banner == null) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            return
        }
    }

    private fun init() {
        rvProductSesuaiPromo = findViewById(R.id.rv_product_sesuai_promo)
        ivBannerProduct = findViewById(R.id.iv_banner_product)
    }

    private fun showSerba17ribuan() {
        listData.addAll(
            listOf(
                HomeCareDatabase.homeCareDatabase3,
                HomeCareDatabase.homeCareDatabase4,
                SanitaryDatabase.sanitaryDatabase1,
                SanitaryDatabase.sanitaryDatabase2,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)

        setAdapter(listData)
    }

    private fun showSerba10ribuan() {
        listData.addAll(
            listOf(
                DiapersDatabase.diapersDatabase1,
                DiapersDatabase.diapersDatabase2,
                DiapersDatabase.diapersDatabase3,
                DiapersDatabase.diapersDatabase4,
                HomeCareDatabase.homeCareDatabase1,
                HomeCareDatabase.homeCareDatabase2,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)

        setAdapter(listData)
    }

    private fun showSerba5ribuan() {
        listData.addAll(
            listOf(
                MakananDatabase.makananDatabase1,
                MakananDatabase.makananDatabase2,
                MakananDatabase.makananDatabase3,
                MakananDatabase.makananDatabase4,
                MakananDatabase.makananDatabase5,
                MakananDatabase.makananDatabase6,
                MakananDatabase.makananDatabase7,
                MakananDatabase.makananDatabase8,
                MakananDatabase.makananDatabase9,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)
    }

    private fun showSanitaryNapkin() {
        listData.addAll(
            listOf(
                SanitaryDatabase.sanitaryDatabase1,
                SanitaryDatabase.sanitaryDatabase2,
                SanitaryDatabase.sanitaryDatabase3,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)
    }

    private fun showSusuHebat() {
        listData.addAll(
            listOf(
                MinumanDatabase.minumanDatabase2,
                MinumanDatabase.minumanDatabase7,
                MinumanDatabase.minumanDatabase8,
                MinumanDatabase.minumanDatabase9,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)
    }

    private fun showHomeCare() {
        listData.addAll(
            listOf(
                HomeCareDatabase.homeCareDatabase1,
                HomeCareDatabase.homeCareDatabase2,
                HomeCareDatabase.homeCareDatabase3,
                HomeCareDatabase.homeCareDatabase4,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)
    }

    private fun showDiapers() {
        listData.addAll(
            listOf(
                DiapersDatabase.diapersDatabase1,
                DiapersDatabase.diapersDatabase2,
                DiapersDatabase.diapersDatabase3,
                DiapersDatabase.diapersDatabase4,
            )
        )
        Glide.with(this).load(banner?.image).into(ivBannerProduct)
        setAdapter(listData)
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


        adapter.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
            override fun goToDetailProduct(position: Int, data: ProductModel) {
                val intent = Intent(
                    this@ProductSesuaiPromoActivity,
                    DetailProductActivity::class.java
                )
                intent.putExtra(Utils.INTENT_DATA, data)
                startActivity(intent)
            }
        })
    }


}