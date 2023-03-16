package com.satellites.main_presentation.search

import com.satellites.main_domain.model.response.list.SatelliteListResponseItem

sealed class SatelliteListUiEvent {
    data class OnSatelliteClick(val satellite: SatelliteListResponseItem) : SatelliteListUiEvent()
}