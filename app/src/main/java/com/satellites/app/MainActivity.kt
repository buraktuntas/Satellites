package com.satellites.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.ExperimentalTextApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.satellites.app.ui.MainScreen
import com.satellites.core_ui.theme.SatellitesTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalTextApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SatellitesTheme {
                MainScreen()
            }
        }
    }
}