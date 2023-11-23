package com.strayalpaca.tiffanyentropy.presentation.screen.notification.model

import com.strayalpaca.tiffanyentropy.domain.notification.model.NotificationItem

data class NotificationUiItem(
    val id : Int,
    val title : String,
    val content : String,
    val createdAt : String
) {
    companion object {
        fun getInstanceFromNotificationItem(notificationItem: NotificationItem) : NotificationUiItem {
            return NotificationUiItem(
                id = notificationItem.id,
                title = notificationItem.title,
                content = notificationItem.content,
                createdAt = notificationItem.createdAt
            )
        }
    }
}