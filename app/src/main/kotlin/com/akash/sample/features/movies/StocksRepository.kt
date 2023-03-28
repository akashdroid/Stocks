package com.akash.sample.features.movies

import com.akash.sample.core.exception.Failure
import com.akash.sample.core.functional.Either
import com.akash.sample.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface StocksRepository {
    fun stockDetails(): Either<Failure, StockDetails>

    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: StockService
    ) : StocksRepository {


        override fun stockDetails(): Either<Failure, StockDetails> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                    service.stockDetails(),
                    {it},
                    StockDetails("", ArrayList())
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R : Any> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}
