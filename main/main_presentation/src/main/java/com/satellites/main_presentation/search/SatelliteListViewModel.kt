package com.satellites.main_presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satellites.core.domain.model.common.ResultState
import com.satellites.core.util.ExceptionHandler
import com.satellites.core_ui.model.InputValueChange
import com.satellites.core_ui.model.InputValueState
import com.satellites.core_ui.model.NavigationType
import com.satellites.core_ui.navigation.Route
import com.satellites.core_ui.util.UiEvent
import com.satellites.main_domain.interactor.CallSatelliteListUseCase
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteListViewModel @Inject constructor(
    private val callSatelliteListUseCase: CallSatelliteListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SatelliteListUiState())
    val uiState: StateFlow<SatelliteListUiState> = _uiState.asStateFlow()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        callGetSatelliteList()
    }

    private fun callGetSatelliteList() {
        viewModelScope.launch(ExceptionHandler.handler) {
            updateSatelliteLoading(true)
            callSatelliteListUseCase(
                onResult = {
                    when (it) {
                        is ResultState.Success -> {
                            updateSatelliteLoading(false)
                            it.data?.satelliteListItem?.let { response ->
                                _uiState.update { currentState ->
                                    currentState.copy(
                                        satelliteList = response,
                                        filterList = response
                                    )
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


    fun searchValueChange(inputValueChange: InputValueChange) {
        updateSearchValue(
            InputValueState(
                text = inputValueChange.newText,
            )
        )
        filterSatelliteList(inputValueChange)
    }

    private fun filterSatelliteList(inputValueChange: InputValueChange) {
        viewModelScope.launch(ExceptionHandler.handler) {
            if (inputValueChange.newText.length > 2) {
                delay(1000)
                val filterList = uiState.value.satelliteList.filter { x ->
                    x?.name?.contains(inputValueChange.newText, true) == true
                }
                _uiState.update { currentState ->
                    currentState.copy(
                        filterList = filterList,
                    )
                }
            } else {
                _uiState.update { currentState ->
                    currentState.copy(
                        filterList = uiState.value.satelliteList,
                    )
                }
            }

        }
    }

    private fun updateSearchValue(searchValueState: InputValueState) {
        viewModelScope.launch(ExceptionHandler.handler) {
            _uiState.update { currentState ->
                currentState.copy(
                    searchValueState = searchValueState
                )
            }
        }

    }

    fun onEvent(satelliteListUiEvent: SatelliteListUiEvent) {
        when (satelliteListUiEvent) {
            is SatelliteListUiEvent.OnSatelliteClick -> {
                onSatellitesClick(satelliteListUiEvent.satellite)
            }
        }
    }

    private fun onSatellitesClick(satellite:SatelliteListResponseItem) {
        viewModelScope.launch(ExceptionHandler.handler) {
            _uiEvent.send(
                UiEvent.Navigate(
                    NavigationType.Navigate(Route.SCR_SATELLITES_DETAIL.name),
                    satellite
                )
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
}