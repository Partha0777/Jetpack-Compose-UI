package com.curiozing.jetpackcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
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
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.curiozing.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import com.curiozing.jetpackcomposeui.utils.MockData
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.White
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
    val icon: Int, val title: String
)

@Composable
fun SideNavigationMenu() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
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
            topEndPercent = 20, bottomEndPercent = 20, bottomStartPercent = 20
        ),
        color = Color(0xFFffde01),
        modifier = Modifier
            .height(height = screenHeight.minus(screenHeight.div(5)).dp)
            .width(width = screenWidth.minus(screenWidth.div(2.25)).dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
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
                                bottomStartPercent = 20, bottomEndPercent = 20
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
                        topEndPercent = 20, bottomEndPercent = 20, bottomStartPercent = 20
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
                                    contentDescription = "profile"
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
                                        top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp
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
                                            top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp
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
                                            top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp
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
                                            top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp
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
                                            top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp
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



    Column {
        Toolbar {
            func()
        }
        Box {
            Column {
                Box {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        item {
                            HomeHeaderContent()
                            Spacer(modifier = Modifier.height(20.dp))
                            HomeFilter()
                            Spacer(modifier = Modifier.height(20.dp))
                            RecentOrder()
                            Spacer(modifier = Modifier.height(20.dp))
                            RecommendedCategory()
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "Recommended",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                        items(MockData.products.chunked(2)) { rowItems ->
                            ProductItem(rowItems)
                        }
                    }
                    TopBar()
                }
            }
        }
    }
}

@Composable
fun ProductItem(rowItems: List<Product>) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        rowItems.forEachIndexed { index, item ->
            Box(
                modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.div(2).dp)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = when (index) {
                            0 -> 16.dp
                            1 -> 8.dp
                            else -> 16.dp
                        }, end = when (index) {
                            0 -> 8.dp
                            1 -> 16.dp
                            else -> 16.dp
                        }, bottom = 24.dp
                    )
                ) {
                    Box {
                        Image(
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(
                                    LocalConfiguration.current.screenHeightDp.div(
                                        4.5
                                    ).dp
                                )
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(20.dp)),
                            painter = rememberAsyncImagePainter(model = item.image),
                            contentDescription = "product"
                        )
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        bottomEnd = 20.dp, topStart = 20.dp
                                    )
                                )
                                .background(color = Color(0xFFffde01))
                                .padding(vertical = 4.dp, horizontal = 16.dp)
                        ) {
                            Text(
                                text = "${"%.1f".format(((item.retailPrice - item.sellingPrice) / item.retailPrice) * 100)}% Off",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(
                            modifier = Modifier.weight(0.7f),
                            text = item.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 2
                        )
                        Row(
                            modifier = Modifier.weight(0.3f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "",
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = item.rating.toString(),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                maxLines = 2
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            text = "$${item.sellingPrice}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "$${item.retailPrice}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 2,
                            color = Color.Gray,
                            style = TextStyle(textDecoration = TextDecoration.LineThrough)
                        )
                    }
                }
            }
        }
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
                        bottomStart = 50.dp, bottomEnd = 50.dp
                    )
                )
        )
        TabBarContent()
    }
}


@Composable
fun RecommendedCategory() {


    Column {
        Text(
            text = "Recommended Category",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        LazyRow(content = {
            MockData.recommendedCategory.take(4).forEach { category ->
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
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
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
                    contentDescription = "category",
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
                        bottomStart = 50.dp, bottomEnd = 50.dp
                    )
                )
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight.div(3.8).dp),
            shape = RoundedCornerShape(
                topStart = 0.dp, topEnd = 0.dp, bottomEnd = 50.dp, bottomStart = 50.dp
            ),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFffde01)),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier.padding(
                    top = LocalConfiguration.current.screenHeightDp.div(10).plus(2).dp
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

    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
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
            MockData.recentOrders.forEachIndexed { index, orders ->
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
        ), elevation = CardDefaults.cardElevation(
            2.dp
        ), modifier = Modifier
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
                            contentDescription = "order",
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
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "orderItem")
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
            IconButton(onClick = {
                func.invoke()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "menuIcon")
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
            topStart = 0.dp, topEnd = 0.dp, bottomEnd = 50.dp, bottomStart = 50.dp
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
                text = "4078 David Cross CA", color = Color.Gray, fontSize = 14.sp
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
                Card(shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 2.dp)
                        .height(68.dp)
                        .width(screenWidth.div(3).dp),
                    onClick = {}) {
                    Row(
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(i.icon),
                            contentDescription = "filterIcon",
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
    var image: Int, var tintColor: Color
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
    val id: Long, val name: String, val image: String
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