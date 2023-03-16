package com.satellites.main_presentation.detail

import com.satellites.main_domain.model.response.detail.SatelliteDetailResponseItem
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem

data class SatelliteDetailUiState(
    var satellite: SatelliteListResponseItem=SatelliteListResponseItem(),
    var satelliteDetail: SatelliteDetailResponseItem=SatelliteDetailResponseItem(),
    val isLoading: Boolean = false,
)