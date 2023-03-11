package com.madeean.weeklyproject3no1.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.madeean.weeklyproject3no1.DetailProductActivity
import com.madeean.weeklyproject3no1.R
import com.madeean.weeklyproject3no1.Utils
import com.madeean.weeklyproject3no1.adapter.AdapterDataProduct
import com.madeean.weeklyproject3no1.database.MinumanDatabase
import com.madeean.weeklyproject3no1.model.ProductModel


class MinumanFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minuman, container, false)


    }

    private lateinit var rvMakanan: RecyclerView
    private lateinit var adapter: AdapterDataProduct
    val listData: ArrayList<ProductModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMakanan = view.findViewById(R.id.rv_makanan)

        listData.addAll(
            listOf(
                MinumanDatabase.minumanDatabase1,
                MinumanDatabase.minumanDatabase2,
                MinumanDatabase.minumanDatabase3,
                MinumanDatabase.minumanDatabase4,
                MinumanDatabase.minumanDatabase5
            )
        )

        rvMakanan.layoutManager = GridLayoutManager(context, 2)
        adapter = AdapterDataProduct(listData, requireContext())
        rvMakanan.adapter = adapter

        adapter.setOnItemClickListener(object : AdapterDataProduct.OnItemClickListener {
            override fun goToDetailProduct(position: Int, data: ProductModel) {
                val intent = Intent(context, DetailProductActivity::class.java)
                intent.putExtra(Utils.INTENT_DATA, data)
                startActivity(intent)
            }
        })

    }


}