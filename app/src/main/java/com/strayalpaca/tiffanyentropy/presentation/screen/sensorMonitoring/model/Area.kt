package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model

data class Area(
    val id : Int = 1,
    val name : String = "용현동"
)

val AreaList = listOf(
    Area(id = 1, name = "용현동"),
    Area(id = 2, name = "도화동"),
    Area(id = 3, name = "주안동"),
    Area(id = 4, name = "관교동"),
    Area(id = 5, name = "문학동"),
    Area(id = 6, name = "만수동")
)