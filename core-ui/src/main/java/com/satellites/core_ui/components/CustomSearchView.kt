package com.satellites.core_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satellites.core_ui.R
import com.satellites.core_ui.model.InputValueChange
import com.satellites.core_ui.model.InputValueState
import com.satellites.core_ui.text.TextBodySmall
import com.satellites.core_ui.text.TextParameters
import com.satellites.core_ui.theme.BlackColor
import com.satellites.core_ui.theme.LocalSpacing
import com.satellites.core_ui.theme.WhiteColor
import com.satellites.core_ui.util.UiText

@Composable
fun CustomSearchView(
    modifier: Modifier,
    inputValueState: InputValueState,
    onValueChange: (InputValueChange) -> Unit,
    labelText: UiText = UiText.DynamicString(""),
    isDigit: Boolean = false,
    minLength: Int? = null,
    maxLength: Int? = null,
) {
    val spacing = LocalSpacing.current

    Box(
        modifier = Modifier
            .border(width = 0.dp, color = WhiteColor, shape = CircleShape)
            .fillMaxWidth()
    ) {

        BasicTextField(
            value = inputValueState.text,
            onValueChange = { newText ->
                onValueChange(
                    InputValueChange(
                        oldText = inputValueState.text,
                        newText = newText,
                        minLength = minLength,
                        maxLength = maxLength,
                        isDigit = isDigit
                    )
                )
            },
            modifier = Modifier
                .background(Color.White, CircleShape)
                .height(spacing.spaceXXXLarge)
                .fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "image",
                        tint = BlackColor
                    )
                    SpaceHorizontal(width = spacing.spaceMedium)

                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (inputValueState.text == "")
                            TextBodySmall(
                                TextParameters(
                                    text = labelText,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Start

                                    ),
                                color = BlackColor
                            )
                        innerTextField()
                    }
                    if (inputValueState.text != "") {
                        IconButton(
                            onClick = {
                                onValueChange(
                                    InputValueChange(
                                        oldText = inputValueState.text,
                                        newText = "",
                                        minLength = minLength,
                                        maxLength = maxLength,
                                        isDigit = isDigit
                                    )
                                )
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "image",
                                tint = BlackColor
                            )
                        }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomSearchView() {
    CustomSearchView(
        modifier = Modifier.fillMaxWidth(),
        labelText = UiText.StringResource(R.string.search),
        inputValueState = InputValueState(),
        onValueChange = { },
        maxLength = 10
    )
}