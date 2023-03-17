package com.satellites.main_domain.model.response.positions

import com.satellites.main_domain.model.response.positions.List as PList

data class SatellitePositionResponse(
    var list : List<PList?> = emptyList()
)