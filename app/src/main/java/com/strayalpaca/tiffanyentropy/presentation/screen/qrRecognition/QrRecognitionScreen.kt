package com.strayalpaca.tiffanyentropy.presentation.screen.qrRecognition

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun QrRecognitionScreen(
    modifier : Modifier = Modifier,
    goBack : () -> Unit,
    viewModel: QrRecognitionViewModel
) {
    Text(text = "QrRecognitionScreen")
}