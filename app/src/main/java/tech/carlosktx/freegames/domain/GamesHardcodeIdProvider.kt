package tech.carlosktx.freegames.domain

import javax.inject.Inject

class GamesHardcodeIdProvider @Inject constructor(): GamesIdProvider {

    companion object {
        private const val NARUTO_ID = 365
        private const val FORNITE_ID = 57
        private const val DC_UNIVERSE_ID = 260
        private const val CONAN_ID = 301
        private const val HALO_ID = 515
        private const val HABBO_ID = 432
        private const val UNTURNED_ID = 204
    }

    override fun getRecommendedGamesId(): List<Int> {
        return listOf(
            NARUTO_ID,
            FORNITE_ID,
            DC_UNIVERSE_ID,
            HABBO_ID,
            CONAN_ID,
            HALO_ID,
            UNTURNED_ID
        )
    }

}