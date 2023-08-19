package tech.carlosktx.freegames.data.remote.mapper

import tech.carlosktx.freegames.data.remote.retrofit.response.GameResponse
import tech.carlosktx.freegames.domain.model.Game

fun GameResponse.toGameModel(): Game {
    return Game(
        id = this.id,
        title = this.title,
        description = this.shortDescription,
        category = this.genre.toGenreModel(this.title),
        thumbnail = this.thumbnail
    )
}