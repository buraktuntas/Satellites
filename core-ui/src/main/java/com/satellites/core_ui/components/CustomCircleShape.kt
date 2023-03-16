package com.satellites.core_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.satellites.core_ui.theme.DisableColor
import com.satellites.core_ui.theme.EnableColor
import com.satellites.core_ui.theme.SatellitesTheme

@Composable
fun CustomCircleShape(
    isEnable: Boolean,
    size: Dp
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .size(size)
            .clip(CircleShape)
            .background(
                color = if (isEnable) {
                    EnableColor
                } else {
                    DisableColor
                }
            ),
        ) {

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCustomCircleShape() {
    SatellitesTheme {
        CustomCircleShape(true, 100.dp)
    }
}

