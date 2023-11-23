package com.strayalpaca.tiffanyentropy.presentation.screen.notification

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NotificationScreen(
    modifier : Modifier = Modifier,
    goBack : () -> Unit,
    viewModel: NotificationViewModel
) {
    Text(text = "NotificationScreen")
}