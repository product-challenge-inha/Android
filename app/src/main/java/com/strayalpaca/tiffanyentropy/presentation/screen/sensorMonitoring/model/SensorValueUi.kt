package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model

import com.madrapps.plot.line.DataPoint
import com.strayalpaca.tiffanyentropy.domain.sensor.model.SensorValues

data class SensorValueUi(
    val value : Int,
    val dateString : String
) {
    companion object {
        fun getInstanceFromSensorValues(sensorValues: SensorValues): SensorValueUi {
            return SensorValueUi(value = sensorValues.value, dateString = sensorValues.createdAt)
        }
    }
}

data class SensorInfoUi(
    val area : Area = Area(),
    val sensorName : String = SensorList[0],
    val values : List<SensorValueUi> = emptyList(),
    val startDate : Date = Date.getInstanceFromPrev3Day(),
    val endDate : Date = Date.getInstanceFromCurrent()
)

fun List<SensorValueUi>.mapToChartPoint() : List<DataPoint> {
    val totalSize = this.size
    return this.mapIndexed { index, sensorValueUi ->
        DataPoint(x = (totalSize - index - 1).toFloat(), y = sensorValueUi.value.toFloat())
    }
}

val SensorList = listOf(
    "TYPE1", "TYPE2", "TYPE3"
)