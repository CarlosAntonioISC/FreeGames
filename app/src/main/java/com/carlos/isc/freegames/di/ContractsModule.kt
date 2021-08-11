package com.carlos.isc.freegames.di

import com.carlos.isc.freegames.data.remote.game.GameRemoteDataSource
import com.carlos.isc.freegames.data.remote.game.GameRemoteDataSourceImpl
import com.carlos.isc.freegames.domain.repository.GameRepository
import com.carlos.isc.freegames.domain.repository.GameRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ContractsModule() {

    @Binds
    abstract fun bindGameRepo(repo: GameRepositoryImpl): GameRepository

    @Binds
    abstract fun bindGameRemoteDataSource(remoteDataSource: GameRemoteDataSourceImpl): GameRemoteDataSource
}