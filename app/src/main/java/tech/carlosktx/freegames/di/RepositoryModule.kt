package tech.carlosktx.freegames.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import tech.carlosktx.freegames.data.repository.GamesRepositoryImpl
import tech.carlosktx.freegames.domain.repository.GamesRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideGameRepository(
        repository: GamesRepositoryImpl
    ): GamesRepository

}