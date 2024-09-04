package com.curiozing.jetpackcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.curiozing.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Home()
                }
            }
        }
    }
}


@Composable
fun Home() {
    SideNavigationMenu()

}

data class HomeFilter(
    val icon: Int,
    val title: String
)

@Composable
fun SideNavigationMenu() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            SideNavContent()
        }, content = {
            HomeContent {
                scope.launch {
                    drawerState.open()
                }
            }
        })
}


@Composable
fun SideNavContent() {
    val localConfiguration = LocalConfiguration
    val screenWidth = localConfiguration.current.screenWidthDp
    val screenHeight = localConfiguration.current.screenHeightDp

    Surface(
        shape = RoundedCornerShape(
            topEndPercent = 20,
            bottomEndPercent = 20,
            bottomStartPercent = 20
        ),
        color = Color(0xFFffde01), modifier = Modifier
            .height(height = screenHeight.minus(screenHeight.div(5)).dp)
            .width(width = screenWidth.minus(screenWidth.div(2.25)).dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(0.93f)
                    .fillMaxSize()
            ) {
                Card(
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                bottomStartPercent = 20,
                                bottomEndPercent = 20
                            )
                        )
                        .fillMaxSize()
                        .padding(bottom = 6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp // Apply elevation here
                    ),
                    shape = RoundedCornerShape(
                        topEndPercent = 20,
                        bottomEndPercent = 20,
                        bottomStartPercent = 20
                    ),
                ) {
                    Column {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "FOODIES",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(40.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(shape = CircleShape)
                                    .background(color = Color(0xFFffde01))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.profile_female),
                                    contentDescription = ""
                                )
                            }
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = "Clara Mia",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Box(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(50))
                                    .background(color = Color(0xFFffde01))
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        top = 4.dp,
                                        bottom = 4.dp,
                                        start = 12.dp,
                                        end = 12.dp
                                    ),
                                    text = "My Orders",
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(50.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Image(
                                        modifier = Modifier.size(30.dp),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.wallet),
                                        contentDescription = "wallet"
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        modifier = Modifier.padding(
                                            top = 4.dp,
                                            bottom = 4.dp,
                                            start = 12.dp,
                                            end = 12.dp
                                        ),
                                        text = "Wallet",
                                        color = Color.DarkGray,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Image(
                                        modifier = Modifier.size(30.dp),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.home),
                                        contentDescription = "home"
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        modifier = Modifier.padding(
                                            top = 4.dp,
                                            bottom = 4.dp,
                                            start = 12.dp,
                                            end = 12.dp
                                        ),
                                        text = "Home",
                                        color = Color.DarkGray,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(40.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Image(
                                        modifier = Modifier.size(30.dp),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.wishlist2),
                                        contentDescription = "wishlist"
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        modifier = Modifier.padding(
                                            top = 4.dp,
                                            bottom = 4.dp,
                                            start = 12.dp,
                                            end = 12.dp
                                        ),
                                        text = "Favourite",
                                        color = Color.DarkGray,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Image(
                                        modifier = Modifier.size(30.dp),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.config),
                                        contentDescription = "config"
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        modifier = Modifier.padding(
                                            top = 4.dp,
                                            bottom = 4.dp,
                                            start = 12.dp,
                                            end = 12.dp
                                        ),
                                        text = "Settings",
                                        color = Color.DarkGray,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                            }
                        }
                    }
                }

            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(0.07f)
                    .fillMaxSize()
                    .padding(bottom = 6.dp)
            ) {
                Text(
                    text = "Log out",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}


@Composable
fun HomeContent(func: () -> Unit) {
    val scrollState = rememberScrollState()
    Column {
        Toolbar {
            func()
        }
        Box {
            Column {
                Box {
                    Column(Modifier.verticalScroll(scrollState)) {
                        HomeHeaderContent()
                        Spacer(modifier = Modifier.height(20.dp))
                        HomeFilter()
                        Spacer(modifier = Modifier.height(20.dp))
                        RecentOrder()
                        Spacer(modifier = Modifier.height(20.dp))
                        RecommendedCategory()
                        Spacer(modifier = Modifier.height(20.dp))
                        RecommendationProducts()
                    }
                    TopBar()
                }

            }
        }
    }

}

@Composable
fun RecommendationProducts() {
    val products = listOf(
        Product(1L, "Kung Pao Chicken", "Chinese", 10.99, 8.99, "Spicy, Chicken", 4.5, "https://www.kitchensanctuary.com/wp-content/uploads/2019/10/Kung-Pao-Chicken-square-FS-39-new.jpg"),
        Product(2L, "Sushi Platter", "Japanese", 15.99, 13.99, "Assorted Fish", 4.8, "https://miamifreshfishmarket.com/cdn/shop/products/platter-12-sushi.jpg?v=1711646076&width=1445"),
        Product(3L, "Tandoori Chicken", "Indian", 12.99, 10.99, "Spicy, Chicken", 4.7, "https://www.easycookingwithmolly.com/wp-content/uploads/2023/11/air-fryer-whole-tandoori-chicken-3.jpg"),
        Product(4L, "Margherita Pizza", "Italian", 9.99, 8.49, "Vegetarian, Cheese", 4.3, "https://cdn.loveandlemons.com/wp-content/uploads/2023/07/margherita-pizza.jpg"),
        Product(5L, "Green Curry", "Thai", 11.99, 10.49, "Spicy, Chicken", 4.6, "https://www.archanaskitchen.com/images/archanaskitchen/0-Archanas-Kitchen-Recipes/2018/Vegetarian_Thai_Green_Curry_Recipe-2-2.jpg"),
        Product(6L, "Tacos", "Mexican", 8.99, 7.99, "Beef, Cheese", 4.5, "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/2/29/0/0149359_Making-Taco_s4x3.jpg.rend.hgtvcom.1280.1280.suffix/1371603491866.webp"),
        Product(7L, "Croissant", "French", 3.99, 2.99, "Butter", 4.8, "https://sarahsvegankitchen.b-cdn.net/wp-content/uploads/2024/05/Vegan-Croissants-1.jpg"),
        Product(8L, "Spring Rolls", "Chinese", 6.99, 5.99, "Vegetarian", 4.2, "https://www.elmundoeats.com/wp-content/uploads/2024/02/Crispy-spring-rolls.jpg"),
        Product(9L, "Pad Thai", "Thai", 11.49, 9.99, "Shrimp, Noodles", 4.4, "https://www.recipetineats.com/tachyon/2020/01/Chicken-Pad-Thai_9-SQ.jpg"),
        Product(10L, "Spaghetti Carbonara", "Italian", 13.99, 11.99, "Bacon, Egg", 4.5, "https://static01.nyt.com/images/2021/02/14/dining/carbonara-horizontal/carbonara-horizontal-square640-v2.jpg"),
        Product(11L, "Biryani", "Indian", 13.99, 12.49, "Chicken, Rice", 4.7, "https://www.kannammacooks.com/wp-content/uploads/buhari-hotel-chennai-chicken-biryani-recipe-1-4.jpg"),
        Product(12L, "Ratatouille", "French", 10.99, 9.99, "Vegetables", 4.6, "https://zenaskitchen.com/wp-content/uploads/2022/02/ratatouille-1.jpg"),
        Product(13L, "Burrito", "Mexican", 9.99, 8.49, "Beef, Rice", 4.3, "https://cdn.britannica.com/13/234013-050-73781543/rice-and-chorizo-burrito.jpg"),
        Product(14L, "Tempura", "Japanese", 14.99, 12.99, "Shrimp, Vegetables", 4.5, "https://www.allrecipes.com/thmb/xWetQsyyrT2R0V4hgS00m2961Hk=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/129467-crispy-shrimp-tempura-ddmfs-4x3-1279-0d2e8debf0e04481acb89f60366bd405.jpg"),
        Product(15L, "Chicken Parmesan", "Italian", 14.49, 12.99, "Chicken, Cheese", 4.6, "https://hips.hearstapps.com/hmg-prod/images/chicken-parmesan-secondary-644041992a1d4.jpg"),
        Product(16L, "Dumplings", "Chinese", 9.99, 8.99, "Pork, Steamed", 4.4, "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2020/11/19/0/MW612_pork-dumplings_s4x3.jpg.rend.hgtvcom.616.462.suffix/1605802271825.webp"),
        Product(17L, "Tom Yum Soup", "Thai", 8.99, 7.99, "Spicy, Shrimp", 4.3, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJxWz9cTtWmg8q9cNuygLcZY4j4LIvcnY8qA&s"),
        Product(18L, "Churros", "Mexican", 4.99, 3.99, "Fried Dough, Sugar", 4.6, "https://www.recipetineats.com/tachyon/2016/08/Churros_9-SQ.jpg"),
        Product(19L, "Butter Chicken", "Indian", 14.99, 13.49, "Creamy, Chicken", 4.8, "https://www.indianhealthyrecipes.com/wp-content/uploads/2023/04/butter-chicken-recipe.jpg"),
        Product(20L, "Macarons", "French", 5.99, 4.99, "Sweet, Almond", 4.7, "https://bakewithshivesh.com/wp-content/uploads/2020/10/IMG-9043-scaled.jpg")
    )


    Column {
        Text(
            text = "Recommended",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        LazyRow(content = {

        })

    }

}

@Composable
fun TopBar() {
    Box(Modifier.background(Color.Transparent)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    LocalConfiguration.current.screenHeightDp
                        .div(10)
                        .plus(2).dp
                )
                .background(
                    color = Color.Gray.copy(alpha = 0.14f), // Adjust color and alpha for desired shadow
                    shape = RoundedCornerShape(
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp
                    )
                )
        )
        TabBarContent()
    }
}


@Composable
fun RecommendedCategory() {

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
            1,
            "French",
            "https://media.tacdn.com/media/attractions-content--1x-1/12/60/c1/ed.jpg"
        ),
        Category(
            1,
            "Thai",
            "https://kampatour.com/pic/blog/a5d47844-5e3b-4172-94c8-ef5027e47ff8.jpg"
        ),
    )
    Column {
        Text(
            text = "Recommended Category",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        LazyRow(content = {
            recommendedCategory.take(4).forEach { category ->
                item {
                    RecommendedCategoryItem(category)
                }
            }
        })

    }
}

@Composable
fun RecommendedCategoryItem(category: Category) {
    Column(
        Modifier
            .padding(start = 20.dp, top = 20.dp)
            .width(
                LocalConfiguration.current.screenWidthDp
                    .div(2)
                    .minus(20).dp
            )
    ) {
        Image(
            painter = rememberAsyncImagePainter(category.image),
            "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(shape = RoundedCornerShape(20.dp))

        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = category.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(color = Color.Black)
                    .padding(all = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    tint = Color(0xFFffde01),
                    modifier = Modifier.size(
                        18.dp
                    )
                )
            }
        }
    }
}


@Composable
fun HomeHeaderContent() {
    val localConfiguration = LocalConfiguration
    val screenHeight = localConfiguration.current.screenHeightDp
    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    screenHeight
                        .div(3.8)
                        .plus(1.5).dp
                )
                .background(
                    color = Color.Gray.copy(alpha = 0.15f), // Adjust color and alpha for desired shadow
                    shape = RoundedCornerShape(
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp
                    )
                )
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight.div(3.8).dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomEnd = 50.dp,
                bottomStart = 50.dp
            ),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFffde01)),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier.padding(
                    top = LocalConfiguration.current.screenHeightDp
                        .div(10)
                        .plus(2).dp
                )
            ) {
                Spacer(Modifier.height(20.dp))
                DeliveryLocationUI()
            }

        }
    }

}


@Composable
fun RecentOrder() {


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

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Row {
                Icon(imageVector = Icons.Default.Refresh, "", Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Recent Orders", fontSize = 14.sp)
            }
            Text(text = "View All", fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(content = {
            recentOrders.forEachIndexed { index, orders ->
                item {
                    RecentOrderItem(orders)
                }
            }
        })
    }

}

@Composable
fun RecentOrderItem(orders: Orders) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            2.dp
        ),
        modifier = Modifier
            .width(screenWidth.minus(40).dp)
            .padding(start = 20.dp)
    ) {
        Column(modifier = Modifier.height(120.dp)) {
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = rememberAsyncImagePainter(orders.image),
                    "orderImage",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Box(
                    Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(color = Color.White)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = orders.rating.toString(), fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "",
                            Modifier.size(14.dp)
                        )
                    }
                }

            }

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(8.0f)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = orders.products, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "$${orders.totalPrice}", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
            }
            Box(modifier = Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "")
            }
        }

    }

}

@Composable
fun Toolbar(func: () -> Unit) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = {
                    func.invoke()
                }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "")
            }
            Text(text = "FOODIES", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Box(
                Modifier
                    .clip(shape = CircleShape)
                    .background(Color(0xFFffde01))
                    .padding(all = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    Modifier.size(16.dp)
                )
            }
        }

    }
}

@Composable
fun TabBarContent() {
    val screenHeight = LocalConfiguration.current.screenHeightDp

    val selectedTopBarIndex = remember {
        mutableIntStateOf(0)
    }

    val topBarImageList = remember {
        mutableStateListOf(
            TopBar(R.drawable.veg_icon, Color.DarkGray),
            TopBar(R.drawable.sea_food_icon, Color.DarkGray),
            TopBar(R.drawable.western_food_icon, Color.DarkGray),
            TopBar(R.drawable.noodles_icon, Color.DarkGray)
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight.div(10).dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomEnd = 50.dp,
            bottomStart = 50.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            topBarImageList.forEachIndexed { index, topbarItem ->
                Box(modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable {
                        selectedTopBarIndex.intValue = index
                    }) {
                    Image(
                        colorFilter = ColorFilter.tint(if (selectedTopBarIndex.intValue == index) Color.DarkGray else Color.Gray),
                        modifier = Modifier
                            .size(50.dp)
                            .padding(all = 8.dp),
                        imageVector = ImageVector.vectorResource(
                            id = topbarItem.image
                        ),
                        contentDescription = "config"
                    )
                }

            }
        }
    }

}


@Composable
fun DeliveryLocationUI() {
    Text(
        text = "Deliver To",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 18.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Box(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth(
            )
            .clip(shape = RoundedCornerShape(50))
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "deliver",
                modifier = Modifier.padding(all = 14.dp)
            )
            Text(text = "Home", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "4078 David Cross CA",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeFilter() {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val homeFilterList = listOf(
        HomeFilter(R.drawable.delivery_in_15_min_icon, "Delivered By 15 Min"),
        HomeFilter(R.drawable.delivery_icon, "Free Delivery"),
        HomeFilter(R.drawable.offer_icon, "Special Offers")
    )


    LazyRow(content = {
        for (i in homeFilterList) {
            item {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .padding(start = 20.dp, end = 2.dp)
                        .height(68.dp)
                        .width(screenWidth.div(3).dp),
                    onClick = {}
                ) {
                    Row(
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(i.icon),
                            contentDescription = "icon",
                            Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = i.title,
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }
    })

}

data class TopBar(
    var image: Int,
    var tintColor: Color
)

data class Orders(
    val orderId: Long,
    val products: String,
    val totalPrice: Double,
    val outLetName: String,
    val rating: Double,
    val image: String
)

data class Category(
    val id: Long,
    val name: String,
    val image: String
)

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


@Preview
@Composable
fun GreetingPreview() {
    JetpackComposeUITheme {
        Home()
    }
}