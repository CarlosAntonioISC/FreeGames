package com.carlos.isc.freegames.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlos.isc.freegames.R
import com.carlos.isc.freegames.databinding.FragmentHomeBinding
import com.carlos.isc.freegames.ui.view.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun setupFragmentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun initElements() {
        mBinding.tvHola.text = "Holaa"
    }
}