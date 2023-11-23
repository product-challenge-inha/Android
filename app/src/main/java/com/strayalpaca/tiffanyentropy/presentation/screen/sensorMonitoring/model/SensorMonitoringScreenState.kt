package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model

import com.strayalpaca.tiffanyentropy.presentation.model.RequestState

data class SensorMonitoringScreenState(
    val sensorValueListLoadState : RequestState = RequestState.IDLE,
    val sensorInfo : SensorInfoUi = SensorInfoUi(),
    val weatherLoadState : RequestState = RequestState.IDLE,
    val weather : WeatherUi = WeatherUi()
)