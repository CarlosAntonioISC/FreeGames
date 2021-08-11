package com.carlos.isc.freegames.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.isc.freegames.R
import com.carlos.isc.freegames.databinding.FragmentHomeBinding
import com.carlos.isc.freegames.domain.core.Result
import com.carlos.isc.freegames.domain.models.Game
import com.carlos.isc.freegames.ui.view.base.BaseFragment
import com.carlos.isc.freegames.ui.view.recyclers.GameAdapter
import com.carlos.isc.freegames.ui.view.viewHelpers.ViewHelperHomeFragment
import com.carlos.isc.freegames.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var mViewHelper: ViewHelperHomeFragment
    private val viewModel: HomeViewModel by viewModels()

    override fun setupFragmentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun initElements() {
        mViewHelper = ViewHelperHomeFragment(mBinding)

        val adapter = GameAdapter()
       // adapter.updateData(mutableListOf(Game("gears"), Game("fifa"), Game("halo")))

        mBinding.recycler.layoutManager = LinearLayoutManager(mContext)
        mBinding.recycler.adapter = adapter
        mBinding.recycler.setHasFixedSize(true)

        viewModel.liveGamesList.observe(viewLifecycleOwner, {
            when(it) {
                is Result.Success -> {
                    Log.d("carloss", "initElements: ${it.data[0].title}")
                    mBinding.loader.visibility = View.GONE
                }
                else -> {
                    mBinding.loader.visibility = View.VISIBLE
                }
            }
        })
    }
}