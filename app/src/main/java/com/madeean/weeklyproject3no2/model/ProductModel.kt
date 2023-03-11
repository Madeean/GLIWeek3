package com.madeean.weeklyproject3no2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val productName: String,
    val productImage: ArrayList<String>,
    val specialPrice: Long?,
    val normalPrice: Long,
    val productDescription: String,
    val stockFrom: String,
    val stock: Int
):Parcelable
