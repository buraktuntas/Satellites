package com.satellites.main_domain.model.response.list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SatelliteListResponseItem(
    val active: Boolean=false,
    val id: Int=-1,
    val name: String=""
): Parcelable