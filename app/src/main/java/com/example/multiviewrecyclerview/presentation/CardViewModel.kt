package com.example.multiviewrecyclerview.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multiviewrecyclerview.data.Card
import com.example.multiviewrecyclerview.data.DataSource
import com.example.multiviewrecyclerview.data.cardList

class CardViewModel(val dataSource: DataSource) : ViewModel() {
    val cardsLiveData = dataSource.getCardList()

    fun getCardForId(id: Long): Card {
        return cardsLiveData.get(id.toInt())
    }
}

//viewModel 생성
class CardViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}