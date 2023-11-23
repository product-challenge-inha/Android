package com.strayalpaca.tiffanyentropy.domain.sensor.usecase

import com.strayalpaca.tiffanyentropy.domain.sensor.model.SensorValues
import com.strayalpaca.tiffanyentropy.domain.sensor.repository.SensorRepository
import javax.inject.Inject

class GetSensorValuesUseCaseImpl @Inject constructor(
    private val sensorRepository: SensorRepository
) : GetSensorValuesUseCase {
    override suspend fun sensorValues(
        areaId: Int,
        sensorType: String,
        startDate: String,
        endDate: String
    ): List<SensorValues> {
        return sensorRepository.getSensorValues(areaId, sensorType, startDate, endDate)
    }
}