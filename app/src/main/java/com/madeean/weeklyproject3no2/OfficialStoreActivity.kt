package com.madeean.weeklyproject3no2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.madeean.weeklyproject3no2.adapter.OfficialStoreAdapter
import com.madeean.weeklyproject3no2.adapter.ProductAdapter
import com.madeean.weeklyproject3no2.database.OfficialStoreDatabase
import com.madeean.weeklyproject3no2.model.ProductModel
import com.madeean.weeklyproject3no2.model.StoreModel

class OfficialStoreActivity : AppCompatActivity() {
    private lateinit var rvOfficialStore: RecyclerView
    private lateinit var adapter: OfficialStoreAdapter
    private val listData = arrayListOf<StoreModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_store)
        init()
        setData()
        setItems(listData)
    }

    private fun setData() {
        listData.addAll(
            arrayListOf(
                OfficialStoreDatabase.Store1,
                OfficialStoreDatabase.Store2,
                OfficialStoreDatabase.Store3,
                OfficialStoreDatabase.Store4,
                OfficialStoreDatabase.Store5,
                OfficialStoreDatabase.Store6,
                OfficialStoreDatabase.Store7,
                OfficialStoreDatabase.Store7,
                OfficialStoreDatabase.Store4,
                OfficialStoreDatabase.Store5,
                OfficialStoreDatabase.Store6,
                OfficialStoreDatabase.Store7,
                OfficialStoreDatabase.Store4,
                OfficialStoreDatabase.Store5,
                OfficialStoreDatabase.Store6,
                OfficialStoreDatabase.Store7,
                OfficialStoreDatabase.Store8
            )
        )
    }

    private fun init() {
        rvOfficialStore = findViewById(R.id.rv_official_store_list)
    }

    private fun setItems(listData: ArrayList<StoreModel>) {
        rvOfficialStore.layoutManager = GridLayoutManager(this, 4)
        adapter = OfficialStoreAdapter(listData, this)
        rvOfficialStore.setHasFixedSize(true)
        rvOfficialStore.adapter = adapter

        adapter.setOnItemClickListener(object : OfficialStoreAdapter.OnItemClickListener {
            override fun goToDetailStore(position: Int, data: StoreModel) {
                val intent = Intent(this@OfficialStoreActivity, DetailStoreActivity::class.java)
                intent.putExtra(Utils.INTENT_STORE_DETAIL, data)
                startActivity(intent)
            }
        })
    }
}