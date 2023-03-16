package com.satellites.core_ui.text

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.satellites.core_ui.util.UiText

data class TextParameters(
    var text: UiText,
    var modifier: Modifier = Modifier,
    var textAlign: TextAlign? = TextAlign.Center,
    var overflow: TextOverflow = TextOverflow.Ellipsis,
    var maxLines: Int = Int.MAX_VALUE,
)