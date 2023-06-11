package tech.carlosktx.freegames.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tech.carlosktx.freegames.data.remote.retrofit.api.GamesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun provideGamesApi(retrofit: Retrofit): GamesApi {
        return retrofit.create(GamesApi::class.java)
    }

}