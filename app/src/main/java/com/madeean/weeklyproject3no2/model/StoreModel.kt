package com.madeean.weeklyproject3no2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreModel(
    val image:String,
    val namaOfficialStore:String
) : Parcelable
