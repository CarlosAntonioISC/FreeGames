package tech.carlosktx.freegames.utils

val String.toCapitalize
    get() = this.lowercase()
        .replaceFirstChar { it.uppercase() }
        .replace("_", " ")