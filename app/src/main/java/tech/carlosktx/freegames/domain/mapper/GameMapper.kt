package tech.carlosktx.freegames.domain.mapper

import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.model.Genre

fun GameDetail.toGame(): Game {
    return Game(
        id = this.id,
        title = this.title,
        description = this.description,
        genre = Genre.SHOOTER,
        thumbnail = this.thumbnail
    )
}