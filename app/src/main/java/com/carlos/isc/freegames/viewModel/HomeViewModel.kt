package com.carlos.isc.freegames.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.carlos.isc.freegames.domain.core.Result
import com.carlos.isc.freegames.domain.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repo: GameRepository): ViewModel() {

    val liveGamesList = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.getLiveGamesList()))
        }catch (e: Exception){
            emit(Result.Failure(e))
        }
    }
}