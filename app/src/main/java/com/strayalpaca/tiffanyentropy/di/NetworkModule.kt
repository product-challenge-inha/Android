package com.strayalpaca.tiffanyentropy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val base_url = "http://3.38.79.42"
    private const val connect_timeout_milli = 10000L
    private const val write_timeout_milli = 10000L
    private const val read_timeout_milli = 5000L

    @Singleton
    @Provides
    fun provideOkhttp(): OkHttpClient {
        val interceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        return OkHttpClient.Builder()
            .connectTimeout(connect_timeout_milli, TimeUnit.MILLISECONDS)
            .writeTimeout(write_timeout_milli, TimeUnit.MILLISECONDS)
            .readTimeout(read_timeout_milli, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}