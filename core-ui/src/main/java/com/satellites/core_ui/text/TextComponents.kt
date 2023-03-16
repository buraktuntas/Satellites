package com.satellites.core_ui.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString

@Composable
fun TextTitleXLarge(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.h1,
        color = color
    )
}

@Composable
fun TextTitleLarge(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.h2,
        color = color
    )
}

@Composable
fun TextTitleMedium(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.h3,
        color = color
    )
}

@Composable
fun TextTitleSmall(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.h4,
        color = color
    )
}

@Composable
fun TextTitleXSmall(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.h5,
        color = color
    )
}

@Composable
fun TextTitleXXSmall(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.h6,
        color = color
    )
}

@Composable
fun TextSubtitleNormal(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.subtitle1,
        color = color
    )
}

@Composable
fun TextSubtitleSmall(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.subtitle2,
        color = color
    )
}

@Composable
fun TextBodyNormal(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.body1,
        color = color
    )
}

@Composable
fun TextBodySmall(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.body2,
        color = color
    )
}

@Composable
fun ClickableTextBodySmall(
    text: AnnotatedString,
    onClick: (() -> Unit)? = null
) {
    ClickableText(
        text = text,
        onClick = {
            if (onClick != null) {
                onClick()
            }
        }
    )
}

@Composable
fun TextButton(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onPrimary
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.button,
        color = color
    )
}

@Composable
fun TextCaption(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.caption,
        color = color
    )
}

@Composable
fun TextOverline(
    textParameters: TextParameters,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        text = textParameters.text.asString(),
        modifier = textParameters.modifier,
        textAlign = textParameters.textAlign,
        maxLines = textParameters.maxLines,
        overflow = textParameters.overflow,
        style = MaterialTheme.typography.overline,
        color = color
    )
}