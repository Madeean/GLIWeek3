package com.madeean.weeklyproject3no2

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.madeean.weeklyproject3no2.Utils.INTENT_DATA
import com.madeean.weeklyproject3no2.adapter.SliderImageAdapter
import com.madeean.weeklyproject3no2.model.ProductModel
import com.smarteist.autoimageslider.SliderView
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.collections.ArrayList

class DetailProductActivity : AppCompatActivity() {
    private lateinit var slider: SliderView
    private lateinit var adapter: SliderImageAdapter

    private lateinit var tvStokFrom: TextView
    private lateinit var tvNamaProduct: TextView
    private lateinit var tvHargaDiskonProduct: TextView
    private lateinit var tvDiskon: TextView
    private lateinit var tvHargaProduct: TextView
    private lateinit var tvDeskripsi: TextView
    private lateinit var ivBack: ImageView

    fun formatter(n: Long) =
        DecimalFormat("#,###", DecimalFormatSymbols(Locale.GERMANY)).format(n)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)
        tvDeskripsi = findViewById(R.id.tv_deskripsi)
        tvHargaProduct = findViewById(R.id.tv_harga_product)
        tvDiskon = findViewById(R.id.tv_diskon)
        tvHargaDiskonProduct = findViewById(R.id.tv_harga_diskon_product)
        tvNamaProduct = findViewById(R.id.tv_nama_product)
        tvStokFrom = findViewById(R.id.tv_stok_from)
        ivBack = findViewById(R.id.iv_back)

        slider = findViewById(R.id.image_slider)

        supportActionBar?.hide()
//        set action bar transparent


        val data = intent.getParcelableExtra<ProductModel>(INTENT_DATA)
        var image: ArrayList<String> = arrayListOf()
        if (data != null) {
            image = data.productImage
            setView(data)
        }

        adapter = SliderImageAdapter(image, this@DetailProductActivity)
        slider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        slider.setSliderAdapter(adapter)
        slider.scrollTimeInSec = 3
        slider.startAutoCycle()

        ivBack.setOnClickListener {


            finish()
        }

    }

    private fun setView(data: ProductModel) {
        tvNamaProduct.text = data.productName
        tvDeskripsi.text = data.productDescription
        if ((data.specialPrice ?: 0) < data.normalPrice) {
            tvHargaDiskonProduct.text =
                getString(R.string.format_harga, formatter(data.normalPrice))
            tvHargaDiskonProduct.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

            tvHargaProduct.text =
                getString(
                    R.string.format_harga, formatter(
                        data.specialPrice ?: 0
                    )
                )


            val hargaAsli = data.normalPrice
            val hargaDiskon = data.specialPrice ?: 0
            var finalDiskon: Int = 0

            try {
                val hitungDiskon: Double = (hargaAsli - hargaDiskon) / hargaAsli.toDouble() * 100
                finalDiskon = hitungDiskon.toInt()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            tvDiskon.text = "$finalDiskon%"
        } else {
            tvHargaDiskonProduct.visibility = View.INVISIBLE
            tvDiskon.visibility = View.INVISIBLE
        }

        tvHargaProduct.text =
            getString(
                R.string.format_harga, formatter(
                    data.specialPrice
                        ?: 0
                )
            )

        tvStokFrom.text =
            getString(R.string.stok_from, data.stockFrom)

        if (data.stockFrom == "Toko") {
//            set drawable start
            tvStokFrom.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.stok_toko,
                0,
                0,
                0
            )
        } else if (data.stockFrom == "Gudang") {
            tvStokFrom.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.stok_gudang,
                0,
                0,
                0
            )
        } else {
            tvStokFrom.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.stok_private_marketplace,
                0,
                0,
                0
            )
        }

    }
}