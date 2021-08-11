package com.carlos.isc.freegames.ui.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlos.isc.freegames.databinding.FragmentHomeBinding
import com.carlos.isc.freegames.domain.core.Result
import com.carlos.isc.freegames.ui.view.base.BaseFragment
import com.carlos.isc.freegames.ui.view.recyclers.GameAdapter
import com.carlos.isc.freegames.ui.view.viewHelpers.ViewHelperHomeFragment
import com.carlos.isc.freegames.utils.hide
import com.carlos.isc.freegames.utils.show
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

        mBinding.recycler.layoutManager = LinearLayoutManager(mContext)
        mBinding.recycler.adapter = adapter
        mBinding.recycler.setHasFixedSize(true)

        viewModel.liveGamesList.observe(viewLifecycleOwner, {
            when(it) {
                is Result.Success -> {
                    adapter.updateData(it.data.toMutableList())
                    mBinding.loader.hide()
                }
                else -> {
                    mBinding.loader.show()
                }
            }
        })
    }
}