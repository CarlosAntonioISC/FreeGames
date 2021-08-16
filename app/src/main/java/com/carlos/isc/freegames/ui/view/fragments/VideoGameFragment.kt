package com.carlos.isc.freegames.ui.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.carlos.isc.freegames.databinding.FragmentVideoGameBinding
import com.carlos.isc.freegames.domain.core.Result
import com.carlos.isc.freegames.ui.view.base.BaseFragment
import com.carlos.isc.freegames.ui.view.viewHelpers.ViewHelperVideoGameFragment
import com.carlos.isc.freegames.utils.hide
import com.carlos.isc.freegames.utils.show
import com.carlos.isc.freegames.viewModel.HomeViewModel
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class VideoGameFragment : BaseFragment<FragmentVideoGameBinding>(), ViewHelperVideoGameFragment.Listener {

    private lateinit var mViewHelper: ViewHelperVideoGameFragment
    private val viewModel: HomeViewModel by activityViewModels()
    private val args: VideoGameFragmentArgs by navArgs()

    private lateinit var idGame: String



    override fun setupFragmentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentVideoGameBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun initElements() {
        mViewHelper = ViewHelperVideoGameFragment(mBinding, mContext, this)
        idGame = args.idGame
        loadData()
    }

    private fun loadData() {
        viewModel.getDetailVideoGame(idGame).observe(viewLifecycleOwner, {
            when (it) {
                is Result.Loading -> { mBinding.loader.show() }
                is Result.Success -> {
                    mBinding.loader.hide()
                    mViewHelper.loadData(it.data)
                }
                is Result.Failure -> { mBinding.loader.hide() }
            }
        })
    }

    override fun addLifeCycleToImageCarousel(imageCarousel: ImageCarousel) {
        imageCarousel.registerLifecycle(lifecycle)
    }

    override fun startActivityURL(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}