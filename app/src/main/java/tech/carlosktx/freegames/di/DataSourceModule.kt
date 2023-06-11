package tech.carlosktx.freegames.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import tech.carlosktx.freegames.data.remote.datasource.GamesRemoteDataSource
import tech.carlosktx.freegames.data.remote.datasource.impl.GamesRetrofitRemoteDataSource

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideGameRemoteDataSource(
        dataSource: GamesRetrofitRemoteDataSource
    ): GamesRemoteDataSource

}