package com.second.world.weather.core.remote

import com.ahinfo.ahteam.core.remote.ResponseWrapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModuleBinds {

    @Binds
    abstract fun bindResponseWrapper(responseWrapper: ResponseWrapper.Base) : ResponseWrapper
}