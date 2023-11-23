package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model

import com.madrapps.plot.line.DataPoint

data class SensorValueUi(
    val value : Int,
    val dateString : String
)

data class SensorInfoUi(
    val positionName : String = "-",
    val sensorName : String = "-",
    val values : List<SensorValueUi> = emptyList(),
    val startDate : Date = Date.getInstanceFromCurrent(),
    val endDate : Date = Date.getInstanceFromPrev3Day()
)

fun List<SensorValueUi>.mapToChartPoint() : List<DataPoint> {
    val totalSize = this.size
    return this.mapIndexed { index, sensorValueUi ->
        DataPoint(x = (totalSize - index - 1).toFloat(), y = sensorValueUi.value.toFloat())
    }
}