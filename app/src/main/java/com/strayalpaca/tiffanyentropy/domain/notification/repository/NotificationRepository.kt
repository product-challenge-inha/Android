package com.strayalpaca.tiffanyentropy.domain.notification.repository

interface NotificationRepository {
    suspend fun sendFirebaseToken(token : String)
}