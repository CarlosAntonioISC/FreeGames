package tech.carlosktx.freegames.domain

interface GamesIdProvider {
    fun getRecommendedGamesId(): List<Int>
}