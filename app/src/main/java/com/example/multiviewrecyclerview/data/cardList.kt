package com.example.multiviewrecyclerview.data

import com.example.multiviewrecyclerview.presentation.MultiViewEnum

fun cardList() : List<Card> {
    return listOf(
        Card(
            0,
            "Anderson",
            "2423 3581 9503 2412",
            "A Debit Card",
            "21/27",
            3100.30,
            "Visa",
            MultiViewEnum.BLUE
        ),
        Card(
            1,
            "Jimmy",
            "1234 5678 1234 1111",
            "A Prepaid Card",
            "19/25",
            5431.40,
            "Master",
            MultiViewEnum.LIGHTBLUE
        ),
        Card(
            2,
            "Hanna",
            "4443 2345 4564 1231",
            "A Credit Card",
            "23/28",
            1030.99,
            "Union",
            MultiViewEnum.ORANGE
        )
    )
}