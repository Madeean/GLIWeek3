package com.madeean.weeklyproject3no2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.adapter.ProductAdapter
import com.madeean.weeklyproject3no2.database.DiapersDatabase.diapersDatabase1
import com.madeean.weeklyproject3no2.database.DiapersDatabase.diapersDatabase2
import com.madeean.weeklyproject3no2.database.DiapersDatabase.diapersDatabase3
import com.madeean.weeklyproject3no2.database.DiapersDatabase.diapersDatabase4
import com.madeean.weeklyproject3no2.database.HomeCareDatabase.homeCareDatabase1
import com.madeean.weeklyproject3no2.database.HomeCareDatabase.homeCareDatabase2
import com.madeean.weeklyproject3no2.database.HomeCareDatabase.homeCareDatabase3
import com.madeean.weeklyproject3no2.database.HomeCareDatabase.homeCareDatabase4
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase1
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase2
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase3
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase4
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase5
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase6
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase7
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase8
import com.madeean.weeklyproject3no2.database.MakananDatabase.makananDatabase9
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase1
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase2
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase3
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase4
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase5
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase7
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase8
import com.madeean.weeklyproject3no2.database.MinumanDatabase.minumanDatabase9
import com.madeean.weeklyproject3no2.database.SanitaryDatabase.sanitaryDatabase1
import com.madeean.weeklyproject3no2.database.SanitaryDatabase.sanitaryDatabase2
import com.madeean.weeklyproject3no2.database.SanitaryDatabase.sanitaryDatabase3
import com.madeean.weeklyproject3no2.model.ProductModel
import com.madeean.weeklyproject3no2.model.StoreModel

class DetailStoreActivity : AppCompatActivity() {
    private lateinit var tvStoreName: TextView
    private lateinit var ivLogoStore: ImageView
    private lateinit var rvStoreProduct: RecyclerView
    private val listData = arrayListOf<ProductModel>()
    private var store: StoreModel? = null
    private lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_store)

        init()
        getData()


        when (store?.namaOfficialStore) {
            "Unilever" -> showUnilever()
            "Indomie" -> showIndomie()
            "Bebelac" -> showBebelac()
            "Aqua" -> showAqua()
            "Mamy Poko" -> showMamyPoko()
            "ABC" -> showABC()
            "Dancow" -> showDancow()
            "Coca Cola" -> showCocaCola()
            "Sari Roti" -> showSariRoti()
            "Frisian Flag" -> showFrisianFlag()
            else -> return
        }

    }

    private fun getData() {
        store = intent.getParcelableExtra(Utils.INTENT_STORE_DETAIL)
        if (store == null) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            return
        }
    }

    private fun init(){
        rvStoreProduct = findViewById(R.id.rv_store_product_list)
        tvStoreName = findViewById(R.id.tv_store_name_detail)
        ivLogoStore = findViewById(R.id.iv_logo_detail)
    }

    private fun showFrisianFlag() {
        listData.addAll(
            listOf(
                minumanDatabase9,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showSariRoti() {
        listData.addAll(
            listOf(
                minumanDatabase5,
                minumanDatabase8,
                minumanDatabase7,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showCocaCola() {
        listData.addAll(
            listOf(
                minumanDatabase2,
                minumanDatabase3,
                minumanDatabase4,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showDancow() {
        listData.addAll(
            listOf(
                makananDatabase8,
                makananDatabase9,
                minumanDatabase1
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showABC() {
        listData.addAll(
            listOf(
                homeCareDatabase3,
                homeCareDatabase4,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showMamyPoko() {
        listData.addAll(
            listOf(
                diapersDatabase4,
                homeCareDatabase1,
                homeCareDatabase2,
                sanitaryDatabase1,
                sanitaryDatabase2,
                sanitaryDatabase3,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showAqua() {
        listData.addAll(
            listOf(
                makananDatabase3,
                makananDatabase4,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showBebelac() {
        listData.addAll(
            listOf(
                makananDatabase5,
                makananDatabase6,
                makananDatabase7,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showIndomie() {
        listData.addAll(
            listOf(
                makananDatabase1,
                makananDatabase2,
            )
        )
        Glide.with(this).load(store?.image).into(ivLogoStore)
        tvStoreName.text = store?.namaOfficialStore
        setAdapter(listData)
    }

    private fun showUnilever() {
        listData.addAll(
            listOf(
                diapersDatabase1,
                diapersDatabase2,
                diapersDatabase3,
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
        rvStoreProduct.isNestedScrollingEnabled = false

        adapter.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
            override fun goToDetailProduct(position: Int, data: ProductModel) {
                val intent = Intent(this@DetailStoreActivity, DetailProductActivity::class.java)
                intent.putExtra(Utils.INTENT_DATA, data)
                startActivity(intent)
            }
        })

    }
}