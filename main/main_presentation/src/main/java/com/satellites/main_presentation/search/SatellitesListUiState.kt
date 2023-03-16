package com.satellites.main_presentation.search

import androidx.compose.ui.focus.FocusRequester
import com.satellites.core_ui.model.InputValueState
import com.satellites.main_domain.model.response.SatelliteListResponseItem

data class SatelliteListUiState(
    var satelliteList: List<SatelliteListResponseItem?> = listOf(),
    var filterList: List<SatelliteListResponseItem?> = listOf(),
    val searchValueState: InputValueState = InputValueState(),
    val searchFocus: FocusRequester = FocusRequester(),
    val isLoading: Boolean = false,
)