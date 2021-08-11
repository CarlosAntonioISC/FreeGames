package com.carlos.isc.freegames.domain.repository

import com.carlos.isc.freegames.domain.models.Game
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.delay
import javax.inject.Inject


@ActivityRetainedScoped
class GameRepositoryImpl @Inject constructor(): GameRepository {

    override suspend fun getLiveGamesList(): List<Game> {
        delay(4000)
        return listOf(Game("","Gears", "","","","",""))
    }
}
