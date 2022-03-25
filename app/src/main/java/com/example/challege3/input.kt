package com.example.challege3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class input(
    val biayaTetap: Int,//ada isinya
    val hargaPerunit: Int,
    val biayaVariabelPerunit: Int
): Parcelable