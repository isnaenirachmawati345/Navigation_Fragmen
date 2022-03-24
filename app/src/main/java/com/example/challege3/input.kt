package com.example.challege3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class input (
    val biaya_tetap : Double,
    val harga_perunit : Double,
    val biaya_variabel_perunit : Double
): Parcelable