package com.madeean.weeklyproject3no1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.madeean.weeklyproject3no1.R
import com.madeean.weeklyproject3no1.adapter.AdapterMakanan
import com.madeean.weeklyproject3no1.database.MakananDatabase
import com.madeean.weeklyproject3no1.database.MakananDatabase.makananDatabase1
import com.madeean.weeklyproject3no1.database.MakananDatabase.makananDatabase2
import com.madeean.weeklyproject3no1.database.MakananDatabase.makananDatabase3
import com.madeean.weeklyproject3no1.database.MakananDatabase.makananDatabase4
import com.madeean.weeklyproject3no1.model.ProductModel

class MakananFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_makanan, container, false)
    }


    private lateinit var rvMakanan: RecyclerView
    private lateinit var adapter: AdapterMakanan
    val listData: ArrayList<ProductModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMakanan = view.findViewById(R.id.rv_makanan)

        listData.addAll(
            listOf(
                makananDatabase1,
                makananDatabase2,
                makananDatabase3,
                makananDatabase4
            )
        )

        rvMakanan.layoutManager = GridLayoutManager(context, 2)
        adapter = AdapterMakanan(listData)
        rvMakanan.adapter = adapter
        

    }
}