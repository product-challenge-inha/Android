package com.strayalpaca.tiffanyentropy.data.sensor.repository

import com.strayalpaca.tiffanyentropy.data.sensor.api.SensorApi
import com.strayalpaca.tiffanyentropy.domain.sensor.model.SensorValues
import com.strayalpaca.tiffanyentropy.domain.sensor.repository.SensorRepository
import retrofit2.Retrofit
import javax.inject.Inject

class SensorRepositoryImpl @Inject constructor(
    retrofit: Retrofit
) : SensorRepository {
    private val sensorRetrofit = retrofit.create(SensorApi::class.java)
    override suspend fun getSensorValues(
        areaId: Int,
        sensorType: String,
        startDate: String,
        endDate: String
    ): List<SensorValues> {
        println("<><> $startDate")
        // val requestBody = SensorValuesRequestBody(areaId.toLong(), sensorType, startDate, endDate )
        val response = sensorRetrofit.getSensorValues(areaId.toLong(), sensorType, startDate, endDate)
        if (response.isSuccessful) {
            return response.body()!!.map {
                SensorValues(areaId, areaId, it.value, sensorType = sensorType, createdAt = it.recordedAt)
            }
        } else {
            println("<><> $response")
            throw IllegalStateException("error from get sensor values!")
        }
    }


}