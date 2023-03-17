package com.satellites.main_domain.model.response.positions

import com.satellites.main_domain.model.response.positions.List as PList

data class List(
    var id: String="",
    var positions: List<Positions> = emptyList()
)