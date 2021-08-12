package com.carlos.isc.freegames.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.carlos.isc.freegames.domain.core.Result
import com.carlos.isc.freegames.domain.repository.VideoGameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repo: VideoGameRepository): ViewModel() {

    val liveGamesList = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.getLiveGamesList()))
        }catch (e: Exception){
            emit(Result.Failure(e))
        }
    }



    fun getDetailVideoGame(idGame: String) = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.getDetailVideoGame(idGame)))
        }catch (e: Exception){
            emit(Result.Failure(e))
        }
    }
}