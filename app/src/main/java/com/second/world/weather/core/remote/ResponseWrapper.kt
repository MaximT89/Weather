package com.second.world.weather.core.remote

import com.ahinfo.ahteam.core.remote.NoInternetConnectionException
import com.second.world.weather.core.bases.BaseResult
import com.second.world.weather.core.bases.Mapper
import retrofit2.Response
import javax.inject.Inject

/**
 * Класс для приема запроса с сервера и разбора его, на выходе мы получаем [BaseResult] в который
 * передаем тип данных соответствующий запросу или ошибку которую получаем в ходе разбора запроса
 */
interface ResponseWrapper {

    suspend fun <T, R> handleResponseWithMapper(
        mapper: Mapper<T, R>,
        apiRequest: suspend () -> Response<T>,
    ): BaseResult<R, Failure>

    suspend fun <T> handleResponse(
        apiRequest: suspend () -> Response<T>,
    ): BaseResult<T, Failure>

    class Impl @Inject constructor() : ResponseWrapper {

        override suspend fun <T, R> handleResponseWithMapper(
            mapper: Mapper<T, R>,
            apiRequest: suspend () -> Response<T>,
        ): BaseResult<R, Failure> {

            return baseResult(apiRequest) { body ->
                BaseResult.Success(mapper.map(body!!))
            }
        }

        override suspend fun <T> handleResponse(
            apiRequest: suspend () -> Response<T>,
        ): BaseResult<T, Failure> {

            return baseResult(apiRequest) { body ->
                BaseResult.Success(body!!)
            }
        }

        private suspend fun <R, T> baseResult(
            apiRequest: suspend () -> Response<T>,
            successResult : (T) -> BaseResult<R, Failure> ,
        ): BaseResult<R, Failure> {
            return try {
                val response = apiRequest.invoke()

                if (response.isSuccessful) {
                    val body = response.body()
                    successResult.invoke(body!!)
                } else {
                    BaseResult.Error(Failure(response.code(), response.message()))
                }
            } catch (e: NoInternetConnectionException) {
                BaseResult.Error(Failure(0, e.message))
            } catch (e: Exception) {
                e.printStackTrace()
                BaseResult.Error(Failure(-1, e.message.toString()))
            }
        }
    }
}