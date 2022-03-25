package com.example.challege3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class input(
    val biaya_tetap: Int,//ada isinya
    val harga_perunit: Int,
    val biaya_variabel_perunit: Int
): Parcelable