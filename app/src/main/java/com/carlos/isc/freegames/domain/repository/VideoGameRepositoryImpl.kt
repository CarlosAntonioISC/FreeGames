package com.carlos.isc.freegames.domain.repository

import com.carlos.isc.freegames.data.remote.game.VideoGameRemoteDataSource
import com.carlos.isc.freegames.domain.models.VideoGameModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
class VideoGameRepositoryImpl @Inject constructor(private val remoteDataSource: VideoGameRemoteDataSource) :
    VideoGameRepository {

    override suspend fun getLiveGamesList(): List<VideoGameModel> {
        return remoteDataSource.getLiveGamesList()
    }
}
