package com.strayalpaca.tiffanyentropy.presentation.screen.qrRecognition

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.presentation.component.block.ToolbarWithBackButton

@Composable
fun QrRecognitionScreen(
    modifier : Modifier = Modifier,
    goBack : () -> Unit,
    viewModel: QrRecognitionViewModel
) {
    Column(modifier) {
        ToolbarWithBackButton(
            onBackClick = goBack,
            title = stringResource(id = R.string.qr_recognition_title)
        )


    }
}