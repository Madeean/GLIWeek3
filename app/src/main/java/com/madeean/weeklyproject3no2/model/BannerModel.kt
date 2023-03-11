package com.madeean.weeklyproject3no2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BannerModel(
    val image: String,
    val namaPromo: String
):Parcelable
