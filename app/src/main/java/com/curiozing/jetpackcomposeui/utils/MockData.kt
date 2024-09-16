package com.curiozing.jetpackcomposeui.utils

import com.curiozing.jetpackcomposeui.model.theme1.Category
import com.curiozing.jetpackcomposeui.model.theme1.Orders
import com.curiozing.jetpackcomposeui.model.theme1.Product
import com.curiozing.jetpackcomposeui.model.themes.Themes

object MockData {

    val themeList = mutableListOf(Themes(1,"Theme 1", "Theme1"))

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

    val products = listOf(
        Product(
            1L,
            "Kung Pao Chicken",
            "Chinese",
            10.99,
            8.99,
            "Spicy, Chicken",
            4.5,
            "https://www.kitchensanctuary.com/wp-content/uploads/2019/10/Kung-Pao-Chicken-square-FS-39-new.jpg"
        ), Product(
            2L,
            "Sushi Platter",
            "Japanese",
            15.99,
            13.99,
            "Assorted Fish",
            4.8,
            "https://miamifreshfishmarket.com/cdn/shop/products/platter-12-sushi.jpg?v=1711646076&width=1445"
        ), Product(
            3L,
            "Tandoori Chicken",
            "Indian",
            12.99,
            10.99,
            "Spicy, Chicken",
            4.7,
            "https://www.easycookingwithmolly.com/wp-content/uploads/2023/11/air-fryer-whole-tandoori-chicken-3.jpg"
        ), Product(
            4L,
            "Margherita Pizza",
            "Italian",
            9.99,
            8.49,
            "Vegetarian, Cheese",
            4.3,
            "https://cdn.loveandlemons.com/wp-content/uploads/2023/07/margherita-pizza.jpg"
        ), Product(
            5L,
            "Green Curry",
            "Thai",
            11.99,
            10.49,
            "Spicy, Chicken",
            4.6,
            "https://www.archanaskitchen.com/images/archanaskitchen/0-Archanas-Kitchen-Recipes/2018/Vegetarian_Thai_Green_Curry_Recipe-2-2.jpg"
        ), Product(
            6L,
            "Tacos",
            "Mexican",
            8.99,
            7.99,
            "Beef, Cheese",
            4.5,
            "https://www.onceuponachef.com/images/2011/02/chicken-tacos-11.jpg"
        ), Product(
            7L,
            "Croissant",
            "French",
            3.99,
            2.99,
            "Butter",
            4.8,
            "https://sarahsvegankitchen.b-cdn.net/wp-content/uploads/2024/05/Vegan-Croissants-1.jpg"
        ), Product(
            8L,
            "Spring Rolls",
            "Chinese",
            6.99,
            5.99,
            "Vegetarian",
            4.2,
            "https://www.elmundoeats.com/wp-content/uploads/2024/02/Crispy-spring-rolls.jpg"
        ), Product(
            9L,
            "Pad Thai",
            "Thai",
            11.49,
            9.99,
            "Shrimp, Noodles",
            4.4,
            "https://www.recipetineats.com/tachyon/2020/01/Chicken-Pad-Thai_9-SQ.jpg"
        ), Product(
            10L,
            "Spaghetti Carbonara",
            "Italian",
            13.99,
            11.99,
            "Bacon, Egg",
            4.5,
            "https://static01.nyt.com/images/2021/02/14/dining/carbonara-horizontal/carbonara-horizontal-square640-v2.jpg"
        ), Product(
            11L,
            "Biryani",
            "Indian",
            13.99,
            12.49,
            "Chicken, Rice",
            4.7,
            "https://www.kannammacooks.com/wp-content/uploads/buhari-hotel-chennai-chicken-biryani-recipe-1-4.jpg"
        ), Product(
            12L,
            "Ratatouille",
            "French",
            10.99,
            9.99,
            "Vegetables",
            4.6,
            "https://zenaskitchen.com/wp-content/uploads/2022/02/ratatouille-1.jpg"
        ), Product(
            13L,
            "Burrito",
            "Mexican",
            9.99,
            8.49,
            "Beef, Rice",
            4.3,
            "https://cdn.britannica.com/13/234013-050-73781543/rice-and-chorizo-burrito.jpg"
        ), Product(
            14L,
            "Tempura",
            "Japanese",
            14.99,
            12.99,
            "Shrimp, Vegetables",
            4.5,
            "https://www.allrecipes.com/thmb/xWetQsyyrT2R0V4hgS00m2961Hk=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/129467-crispy-shrimp-tempura-ddmfs-4x3-1279-0d2e8debf0e04481acb89f60366bd405.jpg"
        ), Product(
            15L,
            "Chicken Parmesan",
            "Italian",
            14.49,
            12.99,
            "Chicken, Cheese",
            4.6,
            "https://hips.hearstapps.com/hmg-prod/images/chicken-parmesan-secondary-644041992a1d4.jpg"
        ), Product(
            16L,
            "Dumplings",
            "Chinese",
            9.99,
            8.99,
            "Pork, Steamed",
            4.4,
            "https://www.bhg.com/thmb/eQgTJ-Bl7DUSNIVQvfntHP3ZVOM=/2000x0/filters:no_upscale():strip_icc()/bhg-pork-and-shitake-steamed-dumplings-FmOg5-5J4gv94CccQYTVph-0ef0a4a8987244759154f9e5e1b1819e.jpg"
        ), Product(
            17L,
            "Tom Yum Soup",
            "Thai",
            8.99,
            7.99,
            "Spicy, Shrimp",
            4.3,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJxWz9cTtWmg8q9cNuygLcZY4j4LIvcnY8qA&s"
        ), Product(
            18L,
            "Churros",
            "Mexican",
            4.99,
            3.99,
            "Fried Dough, Sugar",
            4.6,
            "https://www.recipetineats.com/tachyon/2016/08/Churros_9-SQ.jpg"
        ), Product(
            19L,
            "Butter Chicken",
            "Indian",
            14.99,
            13.49,
            "Creamy, Chicken",
            4.8,
            "https://www.indianhealthyrecipes.com/wp-content/uploads/2023/04/butter-chicken-recipe.jpg"
        ), Product(
            20L,
            "Macarons",
            "French",
            5.99,
            4.99,
            "Sweet, Almond",
            4.7,
            "https://bakewithshivesh.com/wp-content/uploads/2020/10/IMG-9043-scaled.jpg"
        )
    )



}