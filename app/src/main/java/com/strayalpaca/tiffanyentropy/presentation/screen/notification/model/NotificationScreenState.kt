package com.strayalpaca.tiffanyentropy.presentation.screen.notification.model

import com.strayalpaca.tiffanyentropy.presentation.model.RequestState

data class NotificationScreenState(
    val notificationLoadState : RequestState = RequestState.IDLE,
    val notificationList : List<NotificationUiItem> = emptyList(),
)