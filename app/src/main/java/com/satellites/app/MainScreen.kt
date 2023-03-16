package com.satellites.app.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.satellites.core_ui.model.NavigationType
import com.satellites.core_ui.navigation.Route
import com.satellites.core_ui.theme.GreyColor
import com.satellites.main_presentation.detail.SatelliteDetailScreen
import com.satellites.main_presentation.search.SatelliteListScreen

@ExperimentalTextApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun MainScreen() {

    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    val handleNavigation: (NavigationType, Any?) -> Unit = { navigation, data ->
        if (navigation is NavigationType.PopBackNavigate) {
            navController.popBackStack()
        }
        val route = when (navigation) {
            is NavigationType.Navigate -> {
                navigation.route
            }
            is NavigationType.PopBackNavigate -> {
                navigation.route
            }
            is NavigationType.ClearBackStackNavigate -> {
                navigation.route
            }
        }
        navController.navigate(
            route = route
        ) {
            when (navigation) {
                is NavigationType.ClearBackStackNavigate -> {
                    popUpTo(0)
                }
                else -> {}
            }
        }
        navController.getBackStackEntry(
            route = route
        ).savedStateHandle.set(
            key = route,
            value = data
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = GreyColor),
            scaffoldState = scaffoldState,
        ) { paddingValues ->
            NavHost(
                modifier = Modifier
                    .padding(paddingValues),
                navController = navController,
                startDestination = Route.SCR_SATELLITES_LIST.name
            ) {

                composable(Route.SCR_SATELLITES_LIST.name) {
                    SatelliteListScreen(
                        onNavigate = { navType, data ->
                            handleNavigation(navType, data)
                        }
                    )
                }
                composable(Route.SCR_SATELLITES_DETAIL.name) { currentStackEntry ->
                    SatelliteDetailScreen(
                        satellite = currentStackEntry.savedStateHandle[Route.SCR_SATELLITES_DETAIL.name]
                    )
                }
            }
        }
    }
}