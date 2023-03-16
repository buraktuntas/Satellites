package com.satellites.main_data.repository

import android.content.Context
import com.satellites.core.util.readFromAsset
import com.satellites.main_domain.model.response.SatelliteListResponse
import com.satellites.main_domain.model.response.SatelliteListResponseItem
import com.satellites.main_domain.repository.SatellitesRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SatellitesRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context)  : SatellitesRepository {

    override suspend fun callGetSatelliteList(): Flow<SatelliteListResponse?> {
        return flow {

            val jsonFileString = context.applicationContext.readFromAsset("satellite-list.json")
            val moshi = Moshi.Builder().build()
            val adapter: JsonAdapter<List<SatelliteListResponseItem>> = moshi.adapter(Types.newParameterizedType(List::class.java, SatelliteListResponseItem::class.java))
            val satelliteList: List<SatelliteListResponseItem>? = adapter.fromJson(jsonFileString)

            delay(2000) //TODO remove dummy data
            emit(
                satelliteList?.let {
                    SatelliteListResponse(
                        satelliteListItem = it
                    )
                }
            ) //TODO remove dummy data
        }.flowOn(Dispatchers.IO)
    }


}
