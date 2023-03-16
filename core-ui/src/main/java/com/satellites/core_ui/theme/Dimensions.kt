package com.satellites.core_ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val spaceZero: Dp = 0.dp,
    val spaceHalf: Dp = (0.5).dp,
    val spaceOne: Dp = 1.dp,
    val spaceTwo: Dp = 2.dp,
    val spaceXXSmall: Dp = 4.dp,
    val spaceXSmall: Dp = 8.dp,
    val spaceSmall: Dp = 12.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 24.dp,
    val spaceXLarge: Dp = 32.dp,
    val spaceXXLarge: Dp = 36.dp,
    val spaceXXXLarge: Dp = 48.dp,
    val space4XLarge: Dp = 56.dp,
    val space5XLarge: Dp = 64.dp,

    val spaceBorderStroke: Dp = spaceOne,
    val spaceSegmentedProgressRadius: Dp = spaceTwo,
    val spaceScreenHorizontalPadding: Dp = spaceLarge,
    val spaceScreenVerticalPadding: Dp = spaceLarge,
    val spaceScreenBottomPadding: Dp = spaceLarge,
    val spaceTopAppbarHeight: Dp = space5XLarge,
    val spaceTopAppbarHorizontalPadding: Dp = space4XLarge,
    val spaceButtonContentPadding: Dp = spaceSmall,
    val spaceSplashVerticalPadding: Dp = spaceMedium,
    val spaceSplashHorizontalPadding: Dp = spaceXLarge,
)

val LocalSpacing = compositionLocalOf { Dimensions() }
