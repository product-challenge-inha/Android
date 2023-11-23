package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strayalpaca.tiffanyentropy.presentation.model.RequestState
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.SensorMonitoringScreenEvent
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.SensorMonitoringScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SensorMonitoringViewModel @Inject constructor() : ViewModel() {

    private val events = Channel<SensorMonitoringScreenEvent>()
    val state: StateFlow<SensorMonitoringScreenState> = events.receiveAsFlow()
        .runningFold(SensorMonitoringScreenState(), ::reduce)
        .stateIn(viewModelScope, SharingStarted.Eagerly, SensorMonitoringScreenState())

    private fun reduce(state: SensorMonitoringScreenState, events: SensorMonitoringScreenEvent): SensorMonitoringScreenState {
        return when (events) {
            SensorMonitoringScreenEvent.SensorLoadFailure -> {
                state.copy(
                    sensorValueListLoadState = RequestState.FAILURE
                )
            }
            is SensorMonitoringScreenEvent.SensorLoadSuccess -> {
                state.copy(
                    sensorValueListLoadState = RequestState.IDLE,
                    sensorInfo = events.sensorInfoUi
                )
            }
            SensorMonitoringScreenEvent.SensorLoading -> {
                state.copy(
                    sensorValueListLoadState = RequestState.LOADING
                )
            }
            SensorMonitoringScreenEvent.WeatherLoadFailure -> {
                state.copy(
                    weatherLoadState = RequestState.FAILURE
                )
            }
            is SensorMonitoringScreenEvent.WeatherLoadSuccess -> {
                state.copy(
                    weatherLoadState = RequestState.IDLE,
                    weather = events.weatherUi
                )
            }
            SensorMonitoringScreenEvent.WeatherLoading -> {
                state.copy(
                    weatherLoadState = RequestState.LOADING
                )
            }
        }
    }
}