package com.second.world.weather.ui.screens.main_screen

import androidx.fragment.app.viewModels
import com.second.world.weather.core.bases.BaseFragment
import com.second.world.weather.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding,MainViewModel>(FragmentMainBinding::inflate)  {
    override val viewModel: MainViewModel by viewModels()

    override fun initView(): Unit? {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }
}