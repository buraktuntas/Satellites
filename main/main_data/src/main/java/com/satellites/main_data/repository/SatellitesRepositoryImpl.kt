package com.satellites.main_data.repository

import android.content.Context
import com.satellites.core.util.readFromAsset
import com.satellites.main_domain.model.response.detail.SatelliteDetailResponse
import com.satellites.main_domain.model.response.detail.SatelliteDetailResponseItem
import com.satellites.main_domain.model.response.list.SatelliteListResponse
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem
import com.satellites.main_domain.model.response.positions.SatellitePositionResponse
import com.satellites.main_domain.repository.SatellitesRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SatellitesRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val moshi: Moshi
) : SatellitesRepository {

    override suspend fun callGetSatelliteList(): Flow<SatelliteListResponse?> {
        return flow {

            val jsonFileString = context.applicationContext.readFromAsset("satellite-list.json")

            val adapter: JsonAdapter<List<SatelliteListResponseItem>> = moshi.adapter(
                Types.newParameterizedType(
                    List::class.java,
                    SatelliteListResponseItem::class.java
                )
            )
            val satelliteList: List<SatelliteListResponseItem>? = adapter.fromJson(jsonFileString)

            delay(2000)
            emit(
                satelliteList?.let {
                    SatelliteListResponse(
                        satelliteListItem = it
                    )
                }
            )
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun callGetSatelliteDetail(): Flow<SatelliteDetailResponse?> {
        return flow {

            val jsonFileString = context.applicationContext.readFromAsset("satellite-detail.json")
            val adapter: JsonAdapter<List<SatelliteDetailResponseItem>> = moshi.adapter(
                Types.newParameterizedType(
                    List::class.java,
                    SatelliteDetailResponseItem::class.java
                )
            )
            val satelliteDetail: List<SatelliteDetailResponseItem>? =
                adapter.fromJson(jsonFileString)


            delay(2000)
            emit(
                satelliteDetail?.let {
                    SatelliteDetailResponse(
                        satelliteDetailItem = it
                    )
                }
            )
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun callGetSatellitePositions(): Flow<SatellitePositionResponse?> {
        return flow {
            val jsonFileString = context.applicationContext.readFromAsset("positions.json")
            val adapter: JsonAdapter<SatellitePositionResponse> = moshi.adapter(
                SatellitePositionResponse::class.java
            )
            var positionList: SatellitePositionResponse? = adapter.fromJson(jsonFileString)
            delay(2000)
            emit(
                positionList?.let {
                    SatellitePositionResponse(
                        list = it.list
                    )
                }
            )

        }

    }


}
