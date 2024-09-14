package com.curiozing.jetpackcomposeui.model.theme1

data class Orders(
    val orderId: Long,
    val products: String,
    val totalPrice: Double,
    val outLetName: String,
    val rating: Double,
    val image: String
)