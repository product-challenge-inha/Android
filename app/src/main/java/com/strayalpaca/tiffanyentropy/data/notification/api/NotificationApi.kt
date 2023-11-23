package com.strayalpaca.tiffanyentropy.data.notification.api

import com.strayalpaca.tiffanyentropy.data.notification.model.RegisterTokenRequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface NotificationApi {
    @POST("api/device/registerToken")
    suspend fun registerToken(@Body params : RegisterTokenRequestBody)
}