package tech.carlosktx.freegames.data.remote.mapper

import android.util.Log
import tech.carlosktx.freegames.domain.model.Category

fun String?.toGenreModel(name: String): Category {
    val defaultGenre = Category.UNKNOWN.name
    Log.d("carloss", "$this $name")
    val genreName = this?.uppercase()?.replace(" ", "_")
    return try {
        Category.valueOf(genreName ?: defaultGenre)
    } catch (e: Exception) {
        Category.valueOf(defaultGenre)
    }
}