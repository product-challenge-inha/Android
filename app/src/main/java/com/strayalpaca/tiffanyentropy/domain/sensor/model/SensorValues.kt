package com.strayalpaca.tiffanyentropy.domain.sensor.model

data class SensorValues(
    val id : Int,
    val areaId : Int,
    val value : Int,
    val sensorType : SensorTypes,
    val createdAt : String
)
