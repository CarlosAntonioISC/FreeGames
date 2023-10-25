package tech.carlosktx.freegames.di

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ApiModule::class]
)
@Module
object TestAppExtrasModule {

    @Provides
    @Singleton
    @ApiUrl
    fun providesApiUrl() = "http://localhost:8080/"

}