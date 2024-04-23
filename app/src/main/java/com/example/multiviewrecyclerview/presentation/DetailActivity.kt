package com.example.multiviewrecyclerview.presentation

import android.os.Build
import androidx.activity.viewModels
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.multiviewrecyclerview.data.Card
import com.example.multiviewrecyclerview.data.cardList
import com.example.multiviewrecyclerview.databinding.ActivityDetailBinding
import com.example.multiviewrecyclerview.intent.extraNotNull

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }


    private val cardData by lazy {
        //티라미수 버전이상일 경우
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_CARD, Card::class.java)
        } else { // 그 이하
            intent.getParcelableExtra(EXTRA_CARD)
        }
    }

    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }
    private val userId by extraNotNull<Long>(EXTRA_CARD)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        cardViewModel.getCardForId(userId)
        cardData?.let {
            binding.detailName.text = it.userName
            binding.detailPeiod.text = it.period
            binding.detailCardNum.text = it.cardNumber
            binding.detailViewType.text = it.cardType
        }


        /*binding.apply {

        }
        Log.d("debug100", cardViewModel.getCardForId(userId).toString())
    */
    }


    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val cardItem = intent.getParcelableExtra<Card>("cardItem")
        val cardData = cardViewModel.getCardForId(cardItem!!.userId)

        binding.detailName.text = cardItem!!.userName
        binding.detailCardNum.text = cardItem.cardNumber
        binding.detailPeiod.text = cardItem.period
        binding.detailViewType.text = cardItem.cardViewType.name

    }*/
}