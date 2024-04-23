package com.example.multiviewrecyclerview.presentation

import androidx.activity.viewModels
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.multiviewrecyclerview.data.Card
import com.example.multiviewrecyclerview.databinding.ActivityDetailBinding
import com.example.multiviewrecyclerview.intent.extraNotNull

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }
    private val userId by extraNotNull<Long>(EXTRA_CARD)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cardViewModel.getCardForId(userId)

        Log.d("debug100", cardViewModel.getCardForId(userId).toString())
    }

    /*private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val cardItem = intent.getParcelableExtra<Card>(EXTRA_CARD)

        binding.detailName.text = cardItem!!.userName
        binding.detailCardNum.text = cardItem.cardNumber
        binding.detailPeiod.text = cardItem.period
        binding.detailViewType.text = cardItem.cardViewType.name

    }*/
}