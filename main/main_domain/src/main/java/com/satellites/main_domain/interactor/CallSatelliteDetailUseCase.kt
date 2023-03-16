package com.satellites.main_domain.interactor

import com.satellites.core.domain.model.common.ResultState
import com.satellites.main_domain.model.response.detail.SatelliteDetailResponse
import com.satellites.main_domain.repository.SatellitesRepository
import kotlinx.coroutines.flow.catch

class CallSatelliteDetailUseCase(
    private val repository: SatellitesRepository
) {
    suspend operator fun invoke(
        onResult: suspend (ResultState<SatelliteDetailResponse?>) -> Unit
    ) {
        return repository.callGetSatelliteDetail()
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
