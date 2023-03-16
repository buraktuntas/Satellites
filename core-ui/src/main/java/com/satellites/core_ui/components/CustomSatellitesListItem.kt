package com.satellites.core_ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.satellites.core_ui.text.*
import com.satellites.core_ui.theme.BlackColor
import com.satellites.core_ui.theme.LocalSpacing
import com.satellites.core_ui.theme.SatellitesTheme
import com.satellites.core_ui.util.UiText

@Composable
fun CustomSatellitesListItem(
    title: String?,
    active: Boolean,
    onSatelliteClick: () -> Unit,
) {
    val spacing = LocalSpacing.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    onSatelliteClick()
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {

        CustomCircleShape(
            isEnable = active, size = spacing.spaceMedium
        )

        SpaceHorizontal(width = spacing.spaceLarge)

        Column(
            modifier = Modifier
                .wrapContentSize()
                .alpha(
                    if (active) {
                        1.0F
                    } else {
                        0.3F
                    }
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextSubtitleSmall(
                    TextParameters(
                        modifier = Modifier
                            .wrapContentSize(),
                        text = UiText.DynamicString(title ?: ""),
                        textAlign = TextAlign.Start,
                        maxLines = 1
                    )
                )

            }

            SpaceVertical(height = spacing.spaceZero)

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextBodySmall(
                    TextParameters(
                        text = UiText.DynamicString(
                            if (active) {
                                "Active"
                            } else {
                                "Pasive"
                            }
                        ),
                    ),
                    color = BlackColor
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCustomLastOperationListItem() {
    SatellitesTheme {
        Column {
            CustomSatellitesListItem(
                title = "Dragon-1",
                active = true,
                onSatelliteClick = {}
            )
        }
    }
}
