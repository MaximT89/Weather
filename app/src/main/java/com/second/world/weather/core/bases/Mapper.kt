package com.second.world.weather.core.bases

interface Mapper<T, R> {

    fun map(data : T) : R
}