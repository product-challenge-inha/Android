package com.strayalpaca.tiffanyentropy.di

import com.strayalpaca.tiffanyentropy.data.sensor.repository.SensorRepositoryImpl
import com.strayalpaca.tiffanyentropy.domain.sensor.repository.SensorRepository
import com.strayalpaca.tiffanyentropy.domain.sensor.usecase.GetSensorValuesUseCase
import com.strayalpaca.tiffanyentropy.domain.sensor.usecase.GetSensorValuesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {
    @Singleton
    @Provides
    fun provideSensorRepository(
        retrofit : Retrofit
    ) : SensorRepository {
        return SensorRepositoryImpl(retrofit)
    }

    @Singleton
    @Provides
    fun provideGetSensorValuesUseCase(
        sensorRepository: SensorRepository
    ) : GetSensorValuesUseCase {
        return GetSensorValuesUseCaseImpl(sensorRepository)
    }
}