package com.strayalpaca.tiffanyentropy.domain.sensor.usecase

import com.strayalpaca.tiffanyentropy.domain.sensor.model.SensorValues

interface GetSensorValuesUseCase {
    suspend fun sensorValues(areaId : Int, sensorType : String, startDate : String, endDate : String) : List<SensorValues>
}