package com.madeean.weeklyproject3no2

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.madeean.weeklyproject3no2.Utils.INTENT_BANNER_TO_PRODUCT
import com.madeean.weeklyproject3no2.adapter.PromoAlfagiftAdapter
import com.madeean.weeklyproject3no2.database.BannerDatabase
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner1
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner10
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner2
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner3
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner4
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner5
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner6
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner7
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner8
import com.madeean.weeklyproject3no2.database.BannerDatabase.banner9
import com.madeean.weeklyproject3no2.model.BannerModel

class PromoAlfagiftActivity : AppCompatActivity() {
    private lateinit var rvPromoAlfagift: RecyclerView
    private lateinit var promoAlfagiftAdapter: PromoAlfagiftAdapter
    private val listBanner = ArrayList<BannerModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promo_alfagift)
        rvPromoAlfagift = findViewById(R.id.rv_promo_alfagift)

        supportActionBar?.title = "Promo Alfagift"
//        change color toolbar
        supportActionBar?.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.color.red))
        listBanner.addAll(
            listOf(
                banner1,
                banner1,
                banner2,
                banner3,
                banner4,
                banner5,
                banner6,
                banner7,
                banner8,
                banner9,
                banner10,
            )
        )
        rvPromoAlfagift.layoutManager = LinearLayoutManager(this@PromoAlfagiftActivity)
        promoAlfagiftAdapter = PromoAlfagiftAdapter(listBanner, this@PromoAlfagiftActivity)
        rvPromoAlfagift.adapter = promoAlfagiftAdapter

        promoAlfagiftAdapter.setOnItemClickListener(object :
            PromoAlfagiftAdapter.OnItemClickListener {
            override fun goToProduct(position: Int, data: BannerModel) {
                val intent =
                    Intent(this@PromoAlfagiftActivity, ProductSesuaiPromoActivity::class.java)
                intent.putExtra(INTENT_BANNER_TO_PRODUCT, data)
                startActivity(intent)
            }
        })

    }
}