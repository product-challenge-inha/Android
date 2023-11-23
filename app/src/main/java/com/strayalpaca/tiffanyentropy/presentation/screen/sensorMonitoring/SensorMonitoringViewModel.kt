package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring

import androidx.lifecycle.ViewModel
import com.madrapps.plot.line.DataPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SensorMonitoringViewModel @Inject constructor() : ViewModel() {

    val dataPoints1 = listOf(
        DataPoint(0f, 0f),
        DataPoint(1f, 20f),
        DataPoint(2f, 50f),
        DataPoint(3f, 10f),
        DataPoint(4f, 0f),
        DataPoint(5f, -25f),
        DataPoint(6f, -75f),
        DataPoint(7f, -100f),
        DataPoint(8f, -80f),
        DataPoint(9f, -75f),
        DataPoint(10f, -55f),
        DataPoint(11f, -45f),
        DataPoint(12f, 50f),
        DataPoint(13f, 80f),
        DataPoint(14f, 70f),
        DataPoint(15f, 125f),
        DataPoint(16f, 200f),
        DataPoint(17f, 170f),
        DataPoint(18f, 135f),
        DataPoint(19f, 60f),
        DataPoint(20f, 20f),
        DataPoint(21f, 40f),
        DataPoint(22f, 75f),
        DataPoint(23f, 50f),
    )
}