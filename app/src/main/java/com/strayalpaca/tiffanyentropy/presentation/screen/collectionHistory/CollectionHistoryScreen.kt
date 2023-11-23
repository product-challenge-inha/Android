package com.strayalpaca.tiffanyentropy.presentation.screen.collectionHistory

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CollectionHistoryScreen(
    modifier : Modifier = Modifier,
    goBack : () -> Unit,
    viewModel : CollectionHistoryViewModel
) {
    Text(text = "CollectionHistoryScreen")
}