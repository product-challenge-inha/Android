package com.strayalpaca.tiffanyentropy.domain.notification.model

data class NotificationItem(
    val id : Int,
    val title : String,
    val content : String,
    val createdAt : String
)