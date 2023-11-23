package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model

sealed class SensorMonitoringScreenEvent {
    object SensorLoading : SensorMonitoringScreenEvent()
    object SensorLoadFailure : SensorMonitoringScreenEvent()
    class SensorLoadSuccess(val sensorInfoUi: SensorInfoUi) : SensorMonitoringScreenEvent()
    object WeatherLoading : SensorMonitoringScreenEvent()
    object WeatherLoadFailure : SensorMonitoringScreenEvent()
    class WeatherLoadSuccess(val weatherUi: WeatherUi) : SensorMonitoringScreenEvent()
}