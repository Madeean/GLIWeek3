package com.madeean.weeklyproject3no2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madeean.weeklyproject3no2.adapter.PenawaranProductAdapter
import com.madeean.weeklyproject3no2.adapter.ProductAdapter
import com.madeean.weeklyproject3no2.database.MakananDatabase
import com.madeean.weeklyproject3no2.database.MinumanDatabase
import com.madeean.weeklyproject3no2.model.ProductModel

class PenawaranActivity : AppCompatActivity() {
    private lateinit var rvPenawaranTerbaik: RecyclerView
    private lateinit var adapter: ProductAdapter
    private val listData = arrayListOf<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penawaran)
        rvPenawaranTerbaik = findViewById(R.id.rv_Penawaran_List)

        listData.addAll(
                listOf(
                    MinumanDatabase.minumanDatabase1,
                    MinumanDatabase.minumanDatabase2,
                    MinumanDatabase.minumanDatabase3,
                    MinumanDatabase.minumanDatabase4,
                    MinumanDatabase.minumanDatabase5,
                    MakananDatabase.makananDatabase2,
                    MakananDatabase.makananDatabase3,
                    MakananDatabase.makananDatabase4,
                    MakananDatabase.makananDatabase5 ,
                    MakananDatabase.makananDatabase1,
                    MakananDatabase.makananDatabase2,
                    MakananDatabase.makananDatabase3,
                    MakananDatabase.makananDatabase4,
                    MakananDatabase.makananDatabase5
                )
        )
        setItems(listData)

    }

    private fun setItems(listData: ArrayList<ProductModel>) {
        rvPenawaranTerbaik.layoutManager = GridLayoutManager(this, 2)
        adapter = ProductAdapter(listData, this)
        rvPenawaranTerbaik.setHasFixedSize(true)
        rvPenawaranTerbaik.adapter = adapter

        adapter.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
            override fun goToDetailProduct(position: Int, data: ProductModel) {
                val intent = Intent(this@PenawaranActivity, DetailProductActivity::class.java)
                intent.putExtra(Utils.INTENT_DATA, data)
                startActivity(intent)
            }
        })
    }
}