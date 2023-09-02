package tech.carlosktx.freegames.data.remote.mapper

import tech.carlosktx.freegames.domain.model.Category

fun String?.toGenreModel(): Category {
    val defaultGenre = Category.UNKNOWN.name
    val genreName = this?.uppercase()?.replace(" ", "_")
    return try {
        Category.valueOf(genreName ?: defaultGenre)
    } catch (e: Exception) {
        Category.valueOf(defaultGenre)
    }
}