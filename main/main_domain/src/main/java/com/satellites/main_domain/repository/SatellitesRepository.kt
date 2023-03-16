package com.satellites.main_domain.repository

import com.satellites.main_domain.model.response.detail.SatelliteDetailResponse
import com.satellites.main_domain.model.response.list.SatelliteListResponse
import kotlinx.coroutines.flow.Flow

interface SatellitesRepository {
    suspend fun callGetSatelliteList(): Flow<SatelliteListResponse?>

    suspend fun callGetSatelliteDetail(): Flow<SatelliteDetailResponse?>

}