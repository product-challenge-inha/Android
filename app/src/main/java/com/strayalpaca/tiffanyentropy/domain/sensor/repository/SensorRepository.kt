package com.strayalpaca.tiffanyentropy.domain.sensor.repository

import com.strayalpaca.tiffanyentropy.domain.sensor.model.SensorValues

interface SensorRepository {
    suspend fun getSensorValues(areaId : Int, sensorType : String, startDate : String, endDate : String) : List<SensorValues>
}