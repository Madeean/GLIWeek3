package com.madeean.weeklyproject3no1.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.madeean.weeklyproject3no1.DetailProductActivity
import com.madeean.weeklyproject3no1.Utils.INTENT_DATA
import com.madeean.weeklyproject3no1.adapter.AdapterDataProduct
import com.madeean.weeklyproject3no1.database.ElektronikDatabase
import com.madeean.weeklyproject3no1.database.MakananDatabase
import com.madeean.weeklyproject3no1.database.MinumanDatabase
import com.madeean.weeklyproject3no1.database.PakaianDatabase
import com.madeean.weeklyproject3no1.model.ProductModel


class SemuaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            com.madeean.weeklyproject3no1.R.layout.fragment_semua,
            container,
            false
        )
    }

    private lateinit var rvMakanan: RecyclerView
    private lateinit var adapter: AdapterDataProduct
    private val listData: ArrayList<ProductModel> = ArrayList()
    private lateinit var dialog: AlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        setProgressBar()
        setData()
        setAdapter()

    }

    private fun setProgressBar() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setCancelable(false) // if you want user to wait for some process to finish,

        builder.setView(com.madeean.weeklyproject3no1.R.layout.layout_loading_dialog)
        dialog = builder.create()
    }


    private fun setAdapter() {

        rvMakanan.layoutManager = GridLayoutManager(context, 2)
        adapter = AdapterDataProduct(listData, requireContext())
        rvMakanan.adapter = adapter

        dialog.dismiss()

        adapter.setOnItemClickListener(object : AdapterDataProduct.OnItemClickListener {
            override fun goToDetailProduct(position: Int, data: ProductModel) {
                val intent = Intent(context, DetailProductActivity::class.java)
                intent.putExtra(INTENT_DATA, data)
                startActivity(intent)
            }
        })
    }

    private fun init(view: View) {
        rvMakanan = view.findViewById(com.madeean.weeklyproject3no1.R.id.rv_makanan)
    }

    private fun setData() {
        dialog.show()
        listData.addAll(
            listOf(
                ElektronikDatabase.elektronikDatabase1,
                ElektronikDatabase.elektronikDatabase2,
                ElektronikDatabase.elektronikDatabase3,
                ElektronikDatabase.elektronikDatabase4,
                MakananDatabase.makananDatabase1,
                MakananDatabase.makananDatabase2,
                MakananDatabase.makananDatabase3,
                MakananDatabase.makananDatabase4,
                MakananDatabase.makananDatabase5,
                MinumanDatabase.minumanDatabase1,
                MinumanDatabase.minumanDatabase2,
                MinumanDatabase.minumanDatabase3,
                MinumanDatabase.minumanDatabase4,
                MinumanDatabase.minumanDatabase5,
                PakaianDatabase.pakaianDatabase1,
                PakaianDatabase.pakaianDatabase2,
                PakaianDatabase.pakaianDatabase3,
                PakaianDatabase.pakaianDatabase4,
            )
        )
    }


}