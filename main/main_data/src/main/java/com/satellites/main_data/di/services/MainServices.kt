package com.satellites.main_data.di.services

import com.satellites.main_domain.model.response.SatelliteListResponse
import retrofit2.http.GET

interface MainServices {
    @GET("satellites-list")
    suspend fun callSatelliteList(): SatelliteListResponse?
}