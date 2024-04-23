package com.example.multiviewrecyclerview.presentation

import androidx.activity.viewModels
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiviewrecyclerview.data.DataSource
import com.example.multiviewrecyclerview.data.Card
import com.example.multiviewrecyclerview.databinding.ActivityMainBinding
import com.example.multiviewrecyclerview.intent.extraNotNull
import com.example.multiviewrecyclerview.intent.launchActivity
import com.example.multiviewrecyclerview.presentation.DetailActivity.Companion.EXTRA_CARD
import com.standard.multiviewtyperecyclerview.presentation.MultiCardAdapter

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //뷰모델
    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }

    //어뎁터
    private val multiCardAdapter: MultiCardAdapter by lazy {
        MultiCardAdapter { card ->
            adapterOnClick(card)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //viewModel 값 가져오기
        //multiCardAdapter.cardList = DataSource.getDataSource().getCardList()
        multiCardAdapter.cardList = cardViewModel.cardsLiveData

        with(binding.rvItem) {
            adapter = multiCardAdapter
        }
    }

    fun adapterOnClick(card: Card) {
        launchActivity<DetailActivity>(
            DetailActivity.EXTRA_CARD to card.id
        )
    }
    /*private fun adapterOnClick(card: Card) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD, card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }*/
}