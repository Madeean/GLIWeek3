package com.madeean.weeklyproject3no2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.madeean.weeklyproject3no2.adapter.BannerAdapter
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
import com.smarteist.autoimageslider.SliderView

class MainActivity : AppCompatActivity() {
    private lateinit var slider: SliderView
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var tvLihatSemuaBanner: TextView
    private val listBanner = ArrayList<BannerModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvLihatSemuaBanner = findViewById(R.id.tv_lihat_semua_banner)
        slider = findViewById(R.id.slider_banner)
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

        bannerAdapter = BannerAdapter(listBanner, this@MainActivity)
        slider.setSliderAdapter(bannerAdapter)
        slider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        slider.scrollTimeInSec = 2
        slider.startAutoCycle()

        if (listBanner.size <= 10) {
            tvLihatSemuaBanner.visibility = View.GONE
        }

        tvLihatSemuaBanner.setOnClickListener {
            val intent = Intent(this@MainActivity, PromoAlfagiftActivity::class.java)
            startActivity(intent)
        }

    }
}