package com.carlos.isc.freegames.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlos.isc.freegames.databinding.FragmentVideoGameBinding
import com.carlos.isc.freegames.ui.view.base.BaseFragment

class VideoGameFragment : BaseFragment<FragmentVideoGameBinding>() {

    override fun setupFragmentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentVideoGameBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun initElements() {

    }
}