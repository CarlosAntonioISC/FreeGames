package tech.carlosktx.freegames.data.remote.mapper

import tech.carlosktx.freegames.data.remote.retrofit.response.GameResponse
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.Genre

fun GameResponse.toGameModel(): Game {
    return Game(
        id = this.id,
        title = this.title,
        description = this.shortDescription,
        genre = Genre.SHOOTER,
        thumbnail = this.thumbnail
    )
}