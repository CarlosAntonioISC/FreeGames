package tech.carlosktx.freegames.domain.model

class GameDetail(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val status: String,
    val shortDescription: String,
    val description: String,
    val game_url: String,
    val category: Category,
    val platform: String,
    val publisher: String,
    val developer: String,
    val release_date: String,
    val minimumRequirements: MinimumRequirements?,
    val screenshots: List<Screenshot>
)

data class MinimumRequirements(
    val os: String,
    val processor: String,
    val memory: String,
    val graphics: String,
    val storage: String
)

data class Screenshot(
    val id: Int,
    val image: String,
)