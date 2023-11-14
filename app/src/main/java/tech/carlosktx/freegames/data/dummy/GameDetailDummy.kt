package tech.carlosktx.freegames.data.dummy

import tech.carlosktx.freegames.domain.model.Category
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.model.MinimumRequirements
import tech.carlosktx.freegames.domain.model.Screenshot

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
    screenshots = listOf(),
    isFavorite = false
)

val gameDetailDummy2 = GameDetail(
    id = 2,
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
    screenshots = listOf(),
    isFavorite = false
)

val gameDetailDummy3 = GameDetail(
    id = 3,
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
    screenshots = listOf(),
    isFavorite = false
)


val gameDetailHabbo = GameDetail(
    id = 432,
    title = "Habbo",
    thumbnail = "https://www.freetogame.com/g/432/thumbnail.jpg",
    status = "Live",
    shortDescription = "One of the largest and most popular Social MMO.",
    description = "Of all the social MMOs out there",
    game_url = "https://www.freetogame.com/open/habbo",
    category = Category.SOCIAL,
    platform = "Web Browser",
    publisher = "Sulake Corporation",
    developer = "Sulake Corporation",
    release_date = "2001-09-26",
    minimumRequirements = null,
    screenshots = listOf(
        Screenshot(
            id = 1068,
            image = "https://www.freetogame.com/g/432/habbo-1.jpg"
        ),
        Screenshot(
            id = 1069,
            image = "https://www.freetogame.com/g/432/habbo-2.jpg"
        ),
        Screenshot(
            id = 1070,
            image = "https://www.freetogame.com/g/432/habbo-3.jpg"
        ),
        Screenshot(
            id = 1071,
            image = "https://www.freetogame.com/g/432/habbo-4.jpg"
        )
    ),
    isFavorite = false
)


val gamesDetailDummy = listOf(gameDetailDummy1, gameDetailDummy2, gameDetailDummy3)