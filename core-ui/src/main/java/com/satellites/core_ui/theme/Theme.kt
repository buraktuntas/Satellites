package com.satellites.core_ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorPalette = lightColors(
    primary = LightPrimaryColor,
    primaryVariant = LightPrimaryVariantColor,
    secondary = LightSecondaryColor,
    secondaryVariant = LightSecondaryVariantColor,
    background = LightBackgroundColor,
    onBackground = LightOnBackgroundColor,
    surface = LightSurfaceColor,
    onSurface = LightOnSurfaceColor,
    onPrimary = LightOnPrimaryColor,
    onSecondary = LightOnSecondaryColor,
    error = LightErrorColor,
    onError = LightOnErrorColor
)

private val DarkColorPalette = darkColors(
    primary = DarkPrimaryColor,
    primaryVariant = DarkPrimaryVariantColor,
    secondary = DarkSecondaryColor,
    secondaryVariant = DarkSecondaryVariantColor,
    background = DarkBackgroundColor,
    onBackground = DarkOnBackgroundColor,
    surface = DarkSurfaceColor,
    onSurface = DarkOnSurfaceColor,
    onPrimary = DarkOnPrimaryColor,
    onSecondary = DarkOnSecondaryColor,
    error = DarkErrorColor,
    onError = DarkOnErrorColor
)

@Composable
fun SatellitesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}