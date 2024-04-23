package com.example.multiviewrecyclerview.data

import android.os.Parcelable
import com.example.multiviewrecyclerview.presentation.MultiViewEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val id: Int,
    val userName: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
    val cardViewType : MultiViewEnum
) : Parcelable