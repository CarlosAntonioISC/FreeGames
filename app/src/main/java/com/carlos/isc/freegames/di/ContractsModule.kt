package com.carlos.isc.freegames.di

import com.carlos.isc.freegames.data.remote.game.VideoGameRemoteDataSource
import com.carlos.isc.freegames.data.remote.game.VideoGameRemoteDataSourceImpl
import com.carlos.isc.freegames.domain.repository.VideoGameRepository
import com.carlos.isc.freegames.domain.repository.VideoGameRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ContractsModule() {

    @Binds
    abstract fun bindVideoGameRepo(repo: VideoGameRepositoryImpl): VideoGameRepository

    @Binds
    abstract fun bindVideoGameRemoteDataSource(remoteDataSource: VideoGameRemoteDataSourceImpl): VideoGameRemoteDataSource
}