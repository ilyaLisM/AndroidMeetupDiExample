package ru.mobile_broadcast.androidmeetupdiexample.data.remote

import retrofit2.http.GET
import ru.mobile_broadcast.androidmeetupdiexample.data.remote.spacex_dto.SpaceXRocketDto

interface SpaceXApi {

    @GET("rockets")
    suspend fun getRockets(): List<SpaceXRocketDto>
}