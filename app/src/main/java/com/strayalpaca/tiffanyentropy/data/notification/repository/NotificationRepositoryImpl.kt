package com.strayalpaca.tiffanyentropy.data.notification.repository

import com.strayalpaca.tiffanyentropy.data.notification.api.NotificationApi
import com.strayalpaca.tiffanyentropy.data.notification.model.RegisterTokenRequestBody
import com.strayalpaca.tiffanyentropy.domain.notification.repository.NotificationRepository
import retrofit2.Retrofit
import javax.inject.Inject

class NotificationRepositoryImpl @Inject constructor(
    retrofit: Retrofit
) : NotificationRepository {
    private val notificationRetrofit = retrofit.create(NotificationApi::class.java)

    override suspend fun sendFirebaseToken(token: String) {
        notificationRetrofit.registerToken(RegisterTokenRequestBody(token))
    }
}