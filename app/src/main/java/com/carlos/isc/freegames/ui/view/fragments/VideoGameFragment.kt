package com.carlos.isc.freegames.ui.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.carlos.isc.freegames.databinding.FragmentVideoGameBinding
import com.carlos.isc.freegames.domain.core.Result
import com.carlos.isc.freegames.ui.view.base.BaseFragment
import com.carlos.isc.freegames.utils.hide
import com.carlos.isc.freegames.utils.show
import com.carlos.isc.freegames.viewModel.HomeViewModel

class VideoGameFragment : BaseFragment<FragmentVideoGameBinding>() {

    private val viewModel: HomeViewModel by activityViewModels()


    override fun setupFragmentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentVideoGameBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun initElements() {
        viewModel.getDetailVideoGame("457").observe(viewLifecycleOwner, {
            when(it) {
                is Result.Success -> {
                    Log.d("carloss", "sucess $it")
                }
                else -> {
                    Log.d("carloss", "error $it")
                }
            }
        })

    }
}