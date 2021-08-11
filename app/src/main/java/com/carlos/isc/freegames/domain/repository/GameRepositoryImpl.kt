package com.carlos.isc.freegames.domain.repository

import com.carlos.isc.freegames.data.remote.game.GameRemoteDataSource
import com.carlos.isc.freegames.domain.models.GameModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
class GameRepositoryImpl @Inject constructor(private val remoteDataSourceRemote: GameRemoteDataSource) :
    GameRepository {

    override suspend fun getLiveGamesList(): List<GameModel> {
        return remoteDataSourceRemote.getLiveGamesList()
    }
}
