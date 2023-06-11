package tech.carlosktx.freegames.data.remote.datasource.impl

import tech.carlosktx.freegames.data.remote.datasource.GamesRemoteDataSource
import tech.carlosktx.freegames.data.remote.retrofit.api.GamesApi
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.Genre
import javax.inject.Inject

class GamesRetrofitRemoteDataSource @Inject constructor(
    private val gamesApi: GamesApi
) : GamesRemoteDataSource {

    override fun getPopularGames(): List<Game> {
        return listOf(
            Game(
                1,
                "",
                "",
                Genre.SHOOTER,
                ""
            )
        )
    }

}