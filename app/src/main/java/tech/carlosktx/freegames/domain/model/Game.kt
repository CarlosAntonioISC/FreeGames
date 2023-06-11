package tech.carlosktx.freegames.domain.model

data class Game(
    val id: Int,
    val title: String,
    val description: String,
    val genre: Genre,
    val thumbnail: String
)