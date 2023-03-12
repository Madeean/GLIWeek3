package com.madeean.weeklyproject3no2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.madeean.weeklyproject3no2.adapter.BannerAdapter
import com.madeean.weeklyproject3no2.adapter.PenawaranProductAdapter
import com.madeean.weeklyproject3no2.adapter.ProductAdapter
import com.madeean.weeklyproject3no2.adapter.OfficialStoreAdapter
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
import com.madeean.weeklyproject3no2.database.MakananDatabase
import com.madeean.weeklyproject3no2.database.OfficialStoreDatabase
import com.madeean.weeklyproject3no2.model.BannerModel
import com.madeean.weeklyproject3no2.model.ProductModel
import com.madeean.weeklyproject3no2.model.StoreModel
import com.smarteist.autoimageslider.SliderView

class MainActivity : AppCompatActivity() {
    private lateinit var slider: SliderView
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var penawaranAdapter: PenawaranProductAdapter
    private lateinit var storeAdapter: OfficialStoreAdapter
    private lateinit var tvLihatSemuaBanner: TextView
    private lateinit var tvLihatSemuaPenawaran: TextView
    private lateinit var tvLihatSemuaStore: TextView
    private lateinit var recyclerView_penawaran: RecyclerView
    private lateinit var recyclerView_store: RecyclerView
    private val listBanner = ArrayList<BannerModel>()
    private val listProduk = ArrayList<ProductModel>()
    private val listStore = ArrayList<StoreModel>()
    private var listPenawaran = ArrayList<ProductModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvLihatSemuaStore = findViewById(R.id.tv_lihat_semua_official)

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

        recyclerView_penawaran = findViewById(R.id.rv_penawaran_terbaik)

        tvLihatSemuaPenawaran = findViewById(R.id.tv_lihat_semua_penawaran)

        listProduk.addAll(
                arrayListOf(
                    MakananDatabase.makananDatabase1,
                    MakananDatabase.makananDatabase2,
                    MakananDatabase.makananDatabase3,
                    MakananDatabase.makananDatabase4,
                    MakananDatabase.makananDatabase5,
                            MakananDatabase.makananDatabase1,
                    MakananDatabase.makananDatabase2,
                    MakananDatabase.makananDatabase3,
                    MakananDatabase.makananDatabase4,
                    MakananDatabase.makananDatabase5 ,
                            MakananDatabase.makananDatabase1
                )
        )

        tvLihatSemuaPenawaran.setOnClickListener {
            val intent = Intent(this@MainActivity, PenawaranActivity::class.java)
            startActivity(intent)
        }

        listPenawaran = listProduk.filter {
            it.normalPrice> it.specialPrice!!
        } as ArrayList<ProductModel>

        if (listPenawaran.size <= 10) {
            tvLihatSemuaPenawaran.visibility =  View.INVISIBLE
        }

        setAdapter(listPenawaran)

        listStore.addAll(
            arrayListOf(
                OfficialStoreDatabase.Store1,
                OfficialStoreDatabase.Store2,
                OfficialStoreDatabase.Store3,
                OfficialStoreDatabase.Store4,
                OfficialStoreDatabase.Store5,
                OfficialStoreDatabase.Store6,
                OfficialStoreDatabase.Store7,
                OfficialStoreDatabase.Store8
            )
        )

        if (listStore.size <= 10) {
            tvLihatSemuaStore.visibility =  View.INVISIBLE
        }

        tvLihatSemuaStore.setOnClickListener {
            val intent = Intent(this@MainActivity, OfficialStoreActivity::class.java)
            startActivity(intent)
        }

        recyclerView_store = findViewById(R.id.rv_offical_store)

        setAdapterOfficialStore(listStore)

    }

    private fun setAdapter(listData: ArrayList<ProductModel>) {
        recyclerView_penawaran.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        penawaranAdapter = PenawaranProductAdapter(listData, this)
        recyclerView_penawaran.setHasFixedSize(true)
        recyclerView_penawaran.adapter = penawaranAdapter

        penawaranAdapter.setOnItemClickListener(object : PenawaranProductAdapter.OnItemClickListener {
            override fun goToDetailProduct(position: Int, data: ProductModel) {
                val intent = Intent(this@MainActivity, DetailProductActivity::class.java)
                intent.putExtra(Utils.INTENT_DATA, data)
                startActivity(intent)
            }
        })
    }

    private fun setAdapterOfficialStore(listData: ArrayList<StoreModel>) {
        recyclerView_store.layoutManager =  GridLayoutManager(this,4)
        storeAdapter = OfficialStoreAdapter(listData, this)
        recyclerView_store.setHasFixedSize(true)
        recyclerView_store.adapter = storeAdapter
        recyclerView_store.setNestedScrollingEnabled(false);

        storeAdapter.setOnItemClickListener(object : OfficialStoreAdapter.OnItemClickListener {
            override fun goToDetailStore(position: Int, data: StoreModel) {
                val intent = Intent(this@MainActivity, DetailStoreActivity::class.java)
                intent.putExtra(Utils.INTENT_DATA, data)
                startActivity(intent)
            }
        })
    }


}