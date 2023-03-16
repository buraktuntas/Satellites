package com.satellites.main_domain.model.response.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SatelliteDetailResponseItem(
    val cost_per_launch: Int=-1,
    val first_flight: String="",
    val height: Int=-1,
    val id: Int=-1,
    val mass: Int=-1
): Parcelable