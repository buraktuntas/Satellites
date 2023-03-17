package com.satellites.main_presentation.detail

import com.satellites.main_domain.model.response.detail.SatelliteDetailResponseItem
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem
import com.satellites.main_domain.model.response.positions.List

data class SatelliteDetailUiState(
    var satellite: SatelliteListResponseItem=SatelliteListResponseItem(),
    var satelliteDetail: SatelliteDetailResponseItem=SatelliteDetailResponseItem(),
    var positions: List = List(id = "", positions = emptyList()),
    var posX:Double=-1.0,
    var posY:Double=-1.0,
    val isLoading: Boolean = false,
)