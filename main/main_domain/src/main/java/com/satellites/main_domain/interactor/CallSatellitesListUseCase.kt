package com.satellites.main_domain.interactor

import com.satellites.core.domain.model.common.ResultState
import com.satellites.main_domain.model.response.SatelliteListResponse
import com.satellites.main_domain.repository.SatellitesRepository
import kotlinx.coroutines.flow.catch


class CallSatellitesListUseCase(
    private val repository: SatellitesRepository
) {
    suspend operator fun invoke(
        onResult: suspend (ResultState<SatelliteListResponse?>) -> Unit
    ) {
        return repository.callGetSatelliteList()
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