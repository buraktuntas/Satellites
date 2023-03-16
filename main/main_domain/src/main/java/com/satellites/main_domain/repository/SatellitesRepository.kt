package com.satellites.main_domain.repository

import com.satellites.main_domain.model.response.SatelliteListResponse
import kotlinx.coroutines.flow.Flow

interface SatellitesRepository {
    suspend fun callGetSatelliteList(): Flow<SatelliteListResponse?>
}