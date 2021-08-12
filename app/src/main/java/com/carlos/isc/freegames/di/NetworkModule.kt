package com.carlos.isc.freegames.di

import android.content.Context
import com.carlos.isc.freegames.data.remote.game.RetrofitGameWebService
import com.carlos.isc.freegames.domain.core.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    @Provides
    @Singleton
    fun provideRetrofitWebService(retrofit: Retrofit): RetrofitGameWebService {
        return retrofit.create(RetrofitGameWebService::class.java)
    }
}