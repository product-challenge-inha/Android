package com.strayalpaca.tiffanyentropy.presentation.screen.notification.model

sealed class NotificationScreenEvent {
    object NotificationLoading : NotificationScreenEvent()
    object NotificationLoadFailure : NotificationScreenEvent()
    class NotificationLoadSuccess(val notifications : List<NotificationUiItem>) : NotificationScreenEvent()
}
