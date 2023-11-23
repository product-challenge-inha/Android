package com.strayalpaca.tiffanyentropy.data.sensor.api

import com.strayalpaca.tiffanyentropy.data.sensor.model.SensorValueDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SensorApi {
    @GET("sensor-logs")
    suspend fun getSensorValues(
        @Query("areaId") areaId: Long,
        @Query("sensorType") sensorType: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Response<List<SensorValueDto>>
}