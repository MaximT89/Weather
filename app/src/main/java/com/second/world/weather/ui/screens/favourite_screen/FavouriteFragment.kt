package com.second.world.weather.ui.screens.favourite_screen

import androidx.fragment.app.viewModels
import com.second.world.weather.core.bases.BaseFragment
import com.second.world.weather.databinding.FragmentFavouriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FragmentFavouriteBinding, FavouriteViewModel>(FragmentFavouriteBinding::inflate) {
    override val viewModel: FavouriteViewModel by viewModels()

    override fun initView(): Unit? {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }
}