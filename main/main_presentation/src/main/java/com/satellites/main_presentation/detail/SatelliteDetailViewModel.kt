package com.satellites.main_presentation.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satellites.core.domain.model.common.ResultState
import com.satellites.core.util.ExceptionHandler
import com.satellites.core_ui.util.UiEvent
import com.satellites.main_domain.interactor.CallSatelliteDetailUseCase
import com.satellites.main_domain.interactor.CallSatellitePositionsUseCase
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteDetailViewModel @Inject constructor(
    private val callSatelliteDetailUseCase: CallSatelliteDetailUseCase,
    private val callSatellitePositionsUseCase: CallSatellitePositionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SatelliteDetailUiState())
    val uiState: StateFlow<SatelliteDetailUiState> = _uiState.asStateFlow()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        callGetSatelliteDetail()
        callGetPositions()

    }

    private fun callGetSatelliteDetail() {
        viewModelScope.launch(ExceptionHandler.handler) {
            updateSatelliteLoading(true)
            callSatelliteDetailUseCase(
                onResult = {
                    when (it) {
                        is ResultState.Success -> {
                            updateSatelliteLoading(false)
                            it.data?.satelliteDetailItem?.let { response ->
                                response.find { data -> data!!.id == uiState.value.satellite.id }
                                    ?.let { it1 ->
                                        _uiState.update { currentState ->
                                            currentState.copy(
                                                satelliteDetail = it1
                                            )
                                        }
                                    }
                            }
                        }

                        is ResultState.Error -> {
                            _uiEvent.send(
                                UiEvent.ShowError(it.exception)
                            )
                            updateSatelliteLoading(false)
                        }
                        else -> {}
                    }
                }
            )
        }
    }

    private fun callGetPositions() {
        viewModelScope.launch(ExceptionHandler.handler) {
            callSatellitePositionsUseCase(
                onResult = {
                    when (it) {
                        is ResultState.Success -> {
                            it.data?.list?.let { response ->
                                Log.e("response,", response.toString())
                                response.find { data -> uiState.value.satellite.id.toString() == data!!.id }
                                    ?.let { it1 ->
                                        _uiState.update { currentState ->
                                            currentState.copy(
                                                positions = it1
                                            )
                                        }
                                        updatePosXPosY()
                                    }
                            }
                        }

                        is ResultState.Error -> {
                            _uiEvent.send(
                                UiEvent.ShowError(it.exception)
                            )
                        }
                        else -> {}
                    }
                }
            )
        }
    }

    fun updatePosXPosY() {
        viewModelScope.launch(ExceptionHandler.handler) {
            var index = -1
            while (true) {
                index++
                updatePosition(
                    uiState.value.positions.positions[index].posX!!,
                    uiState.value.positions.positions[index].posY!!)
                delay(3000)
                if (index == uiState.value.positions.positions.size-1) {
                    index = -1
                }
            }
        }

    }

    private fun updateSatelliteLoading(isLoading: Boolean) {
        viewModelScope.launch(ExceptionHandler.handler) {
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = isLoading
                )
            }
        }
    }

    fun updateSatelliteId(satellite: SatelliteListResponseItem?) {
        viewModelScope.launch(ExceptionHandler.handler) {
            _uiState.update { currentState ->
                currentState.copy(
                    satellite = satellite!!
                )
            }
        }
    }

    fun updatePosition(posX: Double, posY: Double) {
        viewModelScope.launch(ExceptionHandler.handler) {
            _uiState.update { currentState ->
                currentState.copy(
                    posX = posX,
                    posY = posY
                )
            }
        }
    }
}