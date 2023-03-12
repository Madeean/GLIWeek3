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
import com.madeean.weeklyproject3no1.database.PakaianDatabase
import com.madeean.weeklyproject3no1.model.ProductModel


class PakaianFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pakaian, container, false)
    }

    private lateinit var rvMakanan: RecyclerView
    private lateinit var adapter: AdapterDataProduct
    private val listData: ArrayList<ProductModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)

        setData()

        setAdapter()


    }

    private fun setAdapter() {
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

    private fun setData() {
        listData.addAll(
            listOf(
                PakaianDatabase.pakaianDatabase1,
                PakaianDatabase.pakaianDatabase2,
                PakaianDatabase.pakaianDatabase3,
                PakaianDatabase.pakaianDatabase4,
            )
        )
    }

    private fun init(view:View){
        rvMakanan = view.findViewById(R.id.rv_makanan)
    }


}