package com.standard.multiviewtyperecyclerview.presentation

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiviewrecyclerview.data.Card
import com.example.multiviewrecyclerview.databinding.ItemBlueCardBinding
import com.example.multiviewrecyclerview.databinding.ItemLightBlueCardBinding
import com.example.multiviewrecyclerview.databinding.ItemOrangeCardBinding
import com.example.multiviewrecyclerview.presentation.DetailActivity
import com.example.multiviewrecyclerview.presentation.MultiViewEnum
import java.lang.IllegalArgumentException

//클릭 이벤트 처리 람다함수 파라메터로 사용
class MultiCardAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var cardList = listOf<Card>()


    class BlueTypeViewHolder(private val binding: ItemBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            val context = binding.root.context //adapter에서 clickevent 하면안됨
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
                cardFirst.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_CARD, card)
                    context.startActivity(intent)

                }
            }

        }
    }

    class LightBlueTypeViewHolder(private val binding: ItemLightBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card) {
            val context = binding.root.context
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
                cardSecond.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_CARD, card)
                    context.startActivity(intent)
                }
            }

        }
    }

    class OrangeTypeViewHolder(private val binding: ItemOrangeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            val context = binding.root.context
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
                cardThird.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_CARD, card)
                    context.startActivity(intent)
                }
            }
        }
    }

    //viewholder 생성
    //ViewHolder에 연결된 view 생성, 초기화
    //multi view type 처리
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //multi view type을 구현하는 item layout 연결
        return when (viewType) {
            MultiViewEnum.BLUE.viewType -> {
                val binding =
                    ItemBlueCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlueTypeViewHolder(binding)
            }

            MultiViewEnum.LIGHTBLUE.viewType -> {
                val binding =
                    ItemLightBlueCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                LightBlueTypeViewHolder(binding)
            }

            MultiViewEnum.ORANGE.viewType -> {
                val binding =
                    ItemOrangeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                OrangeTypeViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    //viewHolder와 data 바인딩
    //클릭 이벤트 처리
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cardList[position]

        when (holder.itemViewType) {
            MultiViewEnum.BLUE.viewType -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            MultiViewEnum.LIGHTBLUE.viewType -> {
                val lightBlueHolder = holder as LightBlueTypeViewHolder
                lightBlueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            MultiViewEnum.ORANGE.viewType -> {
                val orangeHolder = holder as OrangeTypeViewHolder
                orangeHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    //아이템의 위치(position)에 따라 어떤 뷰 타입을 가져야하는지 결정
    //position 즉 아이템의 위치에 접근하여 아이템의 뷰타입 결정
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> MultiViewEnum.BLUE.viewType
            1 -> MultiViewEnum.LIGHTBLUE.viewType
            2 -> MultiViewEnum.ORANGE.viewType
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

}