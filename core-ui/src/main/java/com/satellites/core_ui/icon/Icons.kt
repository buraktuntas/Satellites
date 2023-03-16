package com.satellites.core_ui.icon

import androidx.compose.animation.core.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.satellites.core_ui.R

@Composable
fun IconLoading(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()

    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            tween(2000, easing = LinearEasing),
            RepeatMode.Restart
        )
    )

    Icon(
        modifier = modifier
            .rotate(angle),
        tint = Color.Unspecified,
        painter = painterResource(
            id = R.drawable.ic_loading
        ),
        contentDescription = "IconLoading"
    )
}