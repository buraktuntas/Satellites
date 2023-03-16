package com.satellites.main_presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import com.satellites.core_ui.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.satellites.core_ui.components.CustomSatellitesListItem
import com.satellites.core_ui.components.CustomSearchView
import com.satellites.core_ui.components.SpaceVertical
import com.satellites.core_ui.icon.IconLoading
import com.satellites.core_ui.model.InputValueChange
import com.satellites.core_ui.model.NavigationType
import com.satellites.core_ui.text.TextBodySmall
import com.satellites.core_ui.text.TextParameters
import com.satellites.core_ui.theme.BlackColor
import com.satellites.core_ui.theme.GreyColor
import com.satellites.core_ui.theme.LocalSpacing
import com.satellites.core_ui.theme.SatellitesTheme
import com.satellites.core_ui.util.UiEvent
import com.satellites.core_ui.util.UiText
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalPagerApi
@Composable
fun SatelliteListScreen(
    viewModel: SatelliteListViewModel = hiltViewModel(),
    onNavigate: (NavigationType, Any?) -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate<*> -> {
                    onNavigate(event.navigationType, event.data)
                }
                is UiEvent.OpenKeyboard -> {
                    keyboardController?.show()
                }
                is UiEvent.CloseKeyboard -> {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
                is UiEvent.RequestFocus -> {
                    event.focusRequester.requestFocus()
                }
                is UiEvent.MoveFocus -> {
                    focusManager.moveFocus(event.focusDirection)
                }
                else -> {}
            }
        }
    }

    SatelliteListScreenUI(
        uiState = uiState,
        onSatelliteClick = {
            viewModel.onEvent(SatelliteListUiEvent.OnSatelliteClick(
                satellite = it
            ))
        },
        onSearchValueChange = {
            viewModel.searchValueChange(it)
        },
        onSearchKeyboardDone = {
            keyboardController?.hide()
            focusManager.clearFocus()
        },
    )
}

@ExperimentalPagerApi
@Composable
fun SatelliteListScreenUI(
    uiState: SatelliteListUiState,
    onSearchValueChange: (InputValueChange) -> Unit,
    onSearchKeyboardDone: () -> Unit,
    onSatelliteClick: (SatelliteListResponseItem) -> Unit,
) {
    val spacing = LocalSpacing.current
    val filterList = uiState.filterList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GreyColor)
            .padding(
                horizontal = spacing.spaceScreenHorizontalPadding,
                vertical = spacing.spaceScreenVerticalPadding
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomSearchView(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(uiState.searchFocus),
            labelText = UiText.StringResource(R.string.search),
            inputValueState = uiState.searchValueState,
            onValueChange = { valueChangeData ->
                onSearchValueChange(valueChangeData)
            },
            imeAction = ImeAction.Next,
            keyboardOnNext = {
                onSearchKeyboardDone()
            },
            keyboardOnDone = { },
            keyboardType = KeyboardType.Phone,
            isDigit = true
        )
        SpaceVertical(height = spacing.spaceXXXLarge)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            ) {

            if (uiState.isLoading) {
                item {
                    IconLoading(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )
                }
            } else if (filterList.isNotEmpty()) {
                items(filterList.size) { i ->
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = spacing.spaceScreenHorizontalPadding
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomSatellitesListItem(
                            title = filterList[i]!!.name,
                            active = filterList[i]!!.active,
                            onSatelliteClick ={
                                onSatelliteClick(filterList[i]!!)
                            }
                        )


                    }
                    SpaceVertical(height = spacing.spaceXSmall)
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(spacing.spaceHalf)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        BlackColor,
                                        BlackColor
                                    )
                                )
                            )
                    )
                    SpaceVertical(height = spacing.spaceXSmall)

                }
            } else {
                item {
                    TextBodySmall(
                        TextParameters(
                            text = UiText.StringResource(R.string.no_results),
                            modifier = Modifier.fillMaxWidth(),
                        ),
                        color = BlackColor
                    )
                }

            }

        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun PreviewSatelliteListScreenUI() {
    SatellitesTheme {
        SatelliteListScreenUI(
            uiState = SatelliteListUiState(
                satelliteList = (1..6).map {
                    SatelliteListResponseItem(
                        id = 1,
                        name = "Dragon-1",
                        active = false,
                    )
                }
            ),
            onSatelliteClick = {},
            onSearchValueChange = {},
            onSearchKeyboardDone = {},
        )
    }
}

