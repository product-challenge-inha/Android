package com.strayalpaca.tiffanyentropy.presentation.screen.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.presentation.component.block.ToolbarWithBackButton
import com.strayalpaca.tiffanyentropy.presentation.component.template.LoadingFailView
import com.strayalpaca.tiffanyentropy.presentation.component.template.LoadingView
import com.strayalpaca.tiffanyentropy.presentation.model.RequestState
import com.strayalpaca.tiffanyentropy.presentation.screen.notification.model.NotificationScreenState

@Composable
fun NotificationScreen(
    modifier : Modifier = Modifier,
    goBack : () -> Unit,
    viewModel: NotificationViewModel
) {
    val state by viewModel.state.collectAsState()
    NotificationScreenUi(modifier = modifier, onBackClick = goBack, screenState = state)
}

@Composable
fun NotificationScreenUi(
    modifier : Modifier = Modifier,
    onBackClick : () -> Unit,
    screenState: NotificationScreenState
){
    Column(modifier) {
        ToolbarWithBackButton(onBackClick = onBackClick, title = stringResource(id = R.string.notification_title))

        when (screenState.notificationLoadState) {
            RequestState.LOADING -> {
                LoadingView(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth())
            }
            RequestState.FAILURE -> {
                LoadingFailView(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    retry = null
                )
            }
            RequestState.IDLE -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(screenState.notificationList) { item ->

                    }
                }
            }
        }

    }
}