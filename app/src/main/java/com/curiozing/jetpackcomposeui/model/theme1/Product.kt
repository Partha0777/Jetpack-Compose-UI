package com.curiozing.jetpackcomposeui.model.theme1

data class Product(
    val id: Long,
    val name: String,
    val category: String,
    val retailPrice: Double,
    val sellingPrice: Double,
    val options: String,
    val rating: Double,
    val image: String
)