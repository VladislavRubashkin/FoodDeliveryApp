package com.example.fooddeliveryapp.domain.models.useraccount

import com.example.fooddeliveryapp.domain.models.order.Order

data class UserAccount(
    val id: Int,
    val login: String,
    val password: Int,
    val name: String?,
    val avatar: String?,
    val number: Int?,
    val address: String?,
    val orderHistory: List<Order>?
)
