package tech.carlosktx.freegames.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import tech.carlosktx.freegames.domain.GamesIdProvider
import tech.carlosktx.freegames.domain.GamesHardcodeIdProvider

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProviderModule {

    @Binds
    abstract fun provideGameRemoteDataSource(
        dataSource: GamesHardcodeIdProvider
    ): GamesIdProvider


}