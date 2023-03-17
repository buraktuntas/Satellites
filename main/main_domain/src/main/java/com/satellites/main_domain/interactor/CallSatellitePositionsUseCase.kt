package com.satellites.main_domain.interactor

import com.satellites.core.domain.model.common.ResultState
import com.satellites.main_domain.model.response.positions.SatellitePositionResponse
import com.satellites.main_domain.repository.SatellitesRepository
import kotlinx.coroutines.flow.catch

class CallSatellitePositionsUseCase (
    private val repository: SatellitesRepository
) {
    suspend operator fun invoke(
        onResult: suspend (ResultState<SatellitePositionResponse?>) -> Unit
    ) {
        return repository.callGetSatellitePositions()
            .catch {
                onResult(
                    ResultState.Error(it)
                )
            }
            .collect {
                onResult(
                    ResultState.Success(it)
                )
            }
    }
}