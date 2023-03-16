package com.satellites.core_ui.model

sealed class NavigationType {
    data class Navigate(val route: String) : NavigationType()
    data class ClearBackStackNavigate(val route: String) : NavigationType()
    data class PopBackNavigate(val route: String) : NavigationType()
}