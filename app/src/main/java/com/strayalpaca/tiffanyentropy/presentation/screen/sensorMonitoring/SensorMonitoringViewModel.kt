package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strayalpaca.tiffanyentropy.domain.sensor.usecase.GetSensorValuesUseCase
import com.strayalpaca.tiffanyentropy.presentation.model.RequestState
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.Area
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.Date
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.SensorMonitoringScreenEvent
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.SensorMonitoringScreenState
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.SensorValueUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SensorMonitoringViewModel @Inject constructor(
    private val getSensorValuesUseCase: GetSensorValuesUseCase
) : ViewModel() {

    private val sensorExceptionHandler = CoroutineExceptionHandler { _, _ ->
        viewModelScope.launch {
            events.send(SensorMonitoringScreenEvent.SensorLoadFailure)
        }
    }

    private val events = Channel<SensorMonitoringScreenEvent>()
    val state: StateFlow<SensorMonitoringScreenState> = events.receiveAsFlow()
        .runningFold(SensorMonitoringScreenState(), ::reduce)
        .stateIn(viewModelScope, SharingStarted.Eagerly, SensorMonitoringScreenState())

    fun getSensorValuesByDate(startDate: Date, endDate: Date) {
        viewModelScope.launch(Dispatchers.IO + sensorExceptionHandler) {
            events.send(SensorMonitoringScreenEvent.SensorLoading)
            val currentState = state.value.copy()
            val response = getSensorValuesUseCase.sensorValues(
                areaId = currentState.sensorInfo.area.id,
                sensorType = currentState.sensorInfo.sensorName,
                startDate = startDate.getStringOfStart(),
                endDate = endDate.getStringOfEnd()
            )
            val newSensorInfoUi = currentState.sensorInfo.copy(
                startDate = startDate,
                endDate = endDate,
                values = response.map { SensorValueUi.getInstanceFromSensorValues(it) }
            )
            events.send(SensorMonitoringScreenEvent.SensorLoadSuccess(sensorInfoUi = newSensorInfoUi))
        }
    }

    fun getSensorValuesByPosition(area: Area) {
        viewModelScope.launch(Dispatchers.IO) {
            events.send(SensorMonitoringScreenEvent.SensorLoading)
            val currentState = state.value.copy()
            val response = getSensorValuesUseCase.sensorValues(
                areaId = area.id,
                sensorType = currentState.sensorInfo.sensorName,
                startDate = currentState.sensorInfo.startDate.getStringOfStart(),
                endDate = currentState.sensorInfo.endDate.getStringOfEnd()
            )
            val newSensorInfoUi = currentState.sensorInfo.copy(
                area = area,
                values = response.map { SensorValueUi.getInstanceFromSensorValues(it) }
            )
            events.send(SensorMonitoringScreenEvent.SensorLoadSuccess(sensorInfoUi = newSensorInfoUi))
        }
    }

    fun getSensorValuesBySensor(sensorName : String) {
        viewModelScope.launch(Dispatchers.IO + sensorExceptionHandler) {
            events.send(SensorMonitoringScreenEvent.SensorLoading)
            val currentState = state.value.copy()
            val response = getSensorValuesUseCase.sensorValues(
                areaId = currentState.sensorInfo.area.id,
                sensorType = sensorName,
                startDate = currentState.sensorInfo.startDate.getStringOfStart(),
                endDate = currentState.sensorInfo.endDate.getStringOfEnd()
            )
            val newSensorInfoUi = currentState.sensorInfo.copy(
                sensorName = sensorName,
                values = response.map { SensorValueUi.getInstanceFromSensorValues(it) }
            )
            events.send(SensorMonitoringScreenEvent.SensorLoadSuccess(sensorInfoUi = newSensorInfoUi))
        }
    }

    private fun reduce(
        state: SensorMonitoringScreenState,
        events: SensorMonitoringScreenEvent
    ): SensorMonitoringScreenState {
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