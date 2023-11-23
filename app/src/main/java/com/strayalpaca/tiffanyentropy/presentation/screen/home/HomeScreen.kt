package com.strayalpaca.tiffanyentropy.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    modifier : Modifier = Modifier,
    goToSensorMonitoring : () -> Unit,
    goToNotification : () -> Unit,
    goToQrRecognition : () -> Unit,
    goToCollectionHistory : () -> Unit,
    viewModel: HomeViewModel
) {
    HomeScreenUi(
        modifier = modifier
    )
}

@Composable
fun HomeScreenUi(
    modifier : Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Home")
    }
}