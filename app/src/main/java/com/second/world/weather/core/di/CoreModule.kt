package com.second.world.weather.core.di

import com.second.world.weather.core.bases.Dispatchers
import com.second.world.weather.core.remote.ResponseWrapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {

    @Binds
    abstract fun bindResponseWrapper(responseWrapper: ResponseWrapper.Impl) : ResponseWrapper

    @Binds
    abstract fun bindDispatchers(dispatchers : Dispatchers.Impl) : Dispatchers
}