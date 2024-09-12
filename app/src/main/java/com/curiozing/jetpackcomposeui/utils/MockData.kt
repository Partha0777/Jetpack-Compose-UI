package com.curiozing.jetpackcomposeui.utils

import com.curiozing.jetpackcomposeui.Category
import com.curiozing.jetpackcomposeui.Orders

object MockData {
    val recommendedCategory = listOf(
        Category(1, "Italian", "https://onthewood.com/wp-content/uploads/2024/03/Italian1.jpg"),
        Category(
            1,
            "Chinese",
            "https://images-cdn.welcomesoftware.com/Zz0zMDM2ZWM5NmQ5YjAxMWViODcwYmI5NWUzYmNlYzM0NA==/Zz01NTg2OGYyMmQ4MmYxMWViOGM4NjRkNDA4MzFmNzQ4OA%3D%3D.jpg?width=1366"
        ),
        Category(
            1,
            "Indian",
            "https://images.moneycontrol.com/static-mcnews/2023/10/pexels-anil-sharma-10580198-770x433.jpg"
        ),
        Category(
            1,
            "Mexican",
            "https://curlytales.com/wp-content/uploads/2019/10/Best-Mexican-restaurants-in-the-world.jpg"
        ),
        Category(
            1,
            "Japanese",
            "https://www.tastingtable.com/img/gallery/20-japanese-dishes-you-need-to-try-at-least-once/l-intro-1664219638.jpg"
        ),
        Category(
            1, "French", "https://media.tacdn.com/media/attractions-content--1x-1/12/60/c1/ed.jpg"
        ),
        Category(
            1, "Thai", "https://kampatour.com/pic/blog/a5d47844-5e3b-4172-94c8-ef5027e47ff8.jpg"
        ),
    )

    var recentOrders = listOf(
        Orders(
            orderId = 1,
            products = "Chicken Pizza x 2",
            totalPrice = 6.2,
            outLetName = "Pizza Hut",
            rating = 4.3,
            image = "https://www.sargento.com/assets/Uploads/Recipe/Image/TuscanChikPizza_010__FillWzExNzAsNTgzXQ.jpg",
        ),
        Orders(
            orderId = 2,
            products = "Paneer Kadai",
            totalPrice = 2.4,
            outLetName = "Bind Resto",
            rating = 4.5,
            image = "https://dinedelicious.in/wp-content/uploads/2021/10/Kadai-Paneer-Recipe-6.jpg",
        ),
        Orders(
            orderId = 3,
            products = "Cold Brew Black",
            totalPrice = 5.2,
            outLetName = "Starbucks",
            rating = 4.6,
            image = "https://www.simplyrecipes.com/thmb/t9ZeQC3Nb2YUoQTnxUJrjJbnKEA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Simply-Recipes-Cold-Brew-Coffee-LEAD-16-428691bcdd594281b2f5dc6dbc8235e4.jpg",
        ),
        )


}