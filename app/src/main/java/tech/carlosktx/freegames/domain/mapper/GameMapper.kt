package tech.carlosktx.freegames.domain.mapper

import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail

fun GameDetail.toGame(): Game {
    return Game(
        id = this.id,
        title = this.title,
        description = this.description,
        category = this.category,
        thumbnail = this.thumbnail
    )
}