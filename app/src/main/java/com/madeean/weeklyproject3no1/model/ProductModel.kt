package com.madeean.weeklyproject3no1.model

data class ProductModel(
    val productName: String,
    val productImage: ArrayList<String>,
    val specialPrice: Long?,
    val normalPrice: Long,
    val productDescription: String,
    val stockFrom: String,
    val stock: Int
)