package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.presentation.component.block.ToolbarWithBackButton

@Composable
fun SensorMonitoringScreen(
    modifier : Modifier = Modifier,
    goBack : () -> Unit,
    viewModel: SensorMonitoringViewModel
) {

}

@Composable
fun SensorMonitoringScreenUi(
    modifier : Modifier,
    onBackClick : () -> Unit
) {
    Column(modifier) {
        // ToolbarWithBackButton(onBackClick = onBackClick, title = stringResource(id = R.string.sensor_monitoring_title))


    }
}