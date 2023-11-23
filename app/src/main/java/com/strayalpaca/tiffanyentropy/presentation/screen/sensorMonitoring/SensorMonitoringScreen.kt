package com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.presentation.component.block.LineGraph
import com.strayalpaca.tiffanyentropy.presentation.component.block.ToolbarWithBackButton
import com.strayalpaca.tiffanyentropy.presentation.component.block.WeatherItem
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.SensorMonitoringScreenState
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.model.mapToChartPoint

@Composable
fun SensorMonitoringScreen(
    modifier: Modifier = Modifier,
    goBack: () -> Unit,
    viewModel: SensorMonitoringViewModel
) {
    val state by viewModel.state.collectAsState()

    SensorMonitoringScreenUi(modifier = modifier, onBackClick = goBack, state = state)
}

@Composable
fun SensorMonitoringScreenUi(
    modifier: Modifier,
    onBackClick: () -> Unit,
    state: SensorMonitoringScreenState
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        ToolbarWithBackButton(
            onBackClick = onBackClick,
            title = stringResource(id = R.string.sensor_monitoring_title)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = state.sensorInfo.positionName,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.weight(1f),
                text = state.sensorInfo.sensorName,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (state.sensorInfo.values.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
            )
        } else {
            LineGraph(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp),
                data = state.sensorInfo.values.mapToChartPoint()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)) {
            WeatherItem(
                modifier = Modifier.weight(1f),
                title = stringResource(id = R.string.degree),
                imageResourceId = R.drawable.baseline_thermostat_24,
                data = state.weather.degree.toString()
            )
            WeatherItem(
                modifier = Modifier.weight(1f),
                title = stringResource(id = R.string.humidity),
                imageResourceId = R.drawable.baseline_water_drop_24,
                data = state.weather.humidity.toString()
            )
            WeatherItem(
                modifier = Modifier.weight(1f),
                title = stringResource(id = R.string.weather),
                imageResourceId = R.drawable.baseline_outlined_flag_24,
                data = state.weather.weather
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            1.dp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.form_position, state.sensorInfo.positionName))
            Button(onClick = { }) {
                Text(text = stringResource(id = R.string.change))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.form_sensor, state.sensorInfo.sensorName))
            Button(onClick = { }) {
                Text(text = stringResource(id = R.string.change))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.form_period, state.sensorInfo.positionName))
            Button(onClick = { }) {
                Text(text = stringResource(id = R.string.change))
            }
        }
    }
}