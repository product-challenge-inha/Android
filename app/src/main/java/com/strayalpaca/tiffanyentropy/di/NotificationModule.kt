package com.strayalpaca.tiffanyentropy.di

import com.strayalpaca.tiffanyentropy.data.notification.repository.NotificationRepositoryImpl
import com.strayalpaca.tiffanyentropy.domain.notification.repository.NotificationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Singleton
    @Provides
    fun provideNotificationRepository(
        retrofit : Retrofit
    ) : NotificationRepository {
        return NotificationRepositoryImpl(retrofit)
    }
}