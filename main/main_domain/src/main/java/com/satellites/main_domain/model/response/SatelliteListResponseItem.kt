package com.satellites.main_domain.model.response

data class SatelliteListResponseItem(
    val active: Boolean,
    val id: Int,
    val name: String
)