package com.satellites.main_presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satellites.core.domain.model.common.ResultState
import com.satellites.core.util.ExceptionHandler
import com.satellites.core_ui.model.InputValueChange
import com.satellites.core_ui.model.InputValueState
import com.satellites.core_ui.util.UiEvent
import com.satellites.main_domain.interactor.CallSatellitesListUseCase
import com.satellites.main_domain.model.response.SatelliteListResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SatellitesListViewModel @Inject constructor(
    private val callSatellitesListUseCase: CallSatellitesListUseCase
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
            callSatellitesListUseCase(
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
            if(inputValueChange.newText.length>2){
                delay(600)
                val filterList = uiState.value.satelliteList.filter { x ->
                    x?.name?.contains(inputValueChange.newText, true) == true
                }
                _uiState.update { currentState ->
                    currentState.copy(
                        filterList = filterList,
                    )
                }
            }
            else{
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

    fun onEvent(satellitesListUiEvent: SatellitesListUiEvent) {
        when (satellitesListUiEvent) {
            is SatellitesListUiEvent.OnSatelliteClick -> {
                onSatellitesClick()
            }
        }
    }

    private fun onSatellitesClick() {
        viewModelScope.launch(ExceptionHandler.handler) {

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

    suspend fun <T> Flow<T>.throttle(millis: Long): Flow<T> = flow {
        var lastEmissionTime = 0L
        collect { value ->
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastEmissionTime >= millis) {
                emit(value)
                lastEmissionTime = currentTime
            }
        }
    }


}