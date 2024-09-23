package com.curiozing.jetpackcomposeui.model.themes

data class Themes(
    val  themeId:Long,
    val themeName:String,
    val route:String,
    val description:String,
    val category:ThemeCategory
)
enum class ThemeCategory {
    GAMING,
    UTILITY,
    SOCIAL_MEDIA,
    ENTERTAINMENT,
    PRODUCTIVITY,
    ECOMMERCE,
    EDUCATIONAL,
    HEALTH_FITNESS,
    FINANCE,
    TRAVEL,
    NEWS,
    FOOD,
    LIFESTYLE,
    COMMUNICATION
}
