package tech.carlosktx.freegames.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    @Singleton
    @ApiUrl
    fun providesApiUrl() = "https://www.freetogame.com/api/"

}