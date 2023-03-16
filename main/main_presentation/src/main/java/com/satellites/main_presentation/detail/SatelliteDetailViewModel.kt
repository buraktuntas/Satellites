package com.satellites.main_presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satellites.core.domain.model.common.ResultState
import com.satellites.core.util.ExceptionHandler
import com.satellites.core_ui.util.UiEvent
import com.satellites.main_domain.interactor.CallSatelliteDetailUseCase
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteDetailViewModel @Inject constructor(
    private val callSatelliteDetailUseCase: CallSatelliteDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SatelliteDetailUiState())
    val uiState: StateFlow<SatelliteDetailUiState> = _uiState.asStateFlow()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        callGetSatelliteDetail()
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
}