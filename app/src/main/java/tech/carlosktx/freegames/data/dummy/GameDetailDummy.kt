package tech.carlosktx.freegames.data.dummy

import tech.carlosktx.freegames.domain.model.Category
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.model.MinimumRequirements

val gameDetailDummy1 = GameDetail(
    id = 1,
    title = "",
    thumbnail = "",
    status = "",
    shortDescription = "",
    description = "",
    game_url = "",
    category = Category.CARDS,
    platform = "",
    publisher = "",
    developer = "",
    release_date = "",
    minimumRequirements = MinimumRequirements(
        os = "",
        processor = "",
        memory = "",
        graphics = "",
        storage = ""
    ),
    screenshots = listOf()
)