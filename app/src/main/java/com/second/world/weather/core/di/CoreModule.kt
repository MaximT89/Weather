package com.second.world.weather.core.di

import com.second.world.weather.core.bases.Dispatchers
import com.second.world.weather.core.common.ResourceProvider
import com.second.world.weather.core.remote.NetworkInterceptor
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

    @Binds
    abstract fun bindResourceProvider(provider : ResourceProvider.Impl) : ResourceProvider

    @Binds
    abstract fun bindNetworkInterceptor(interceptor: NetworkInterceptor.Impl) : NetworkInterceptor
}