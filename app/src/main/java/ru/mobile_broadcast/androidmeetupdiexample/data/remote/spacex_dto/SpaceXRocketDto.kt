package ru.mobile_broadcast.androidmeetupdiexample.data.remote.spacex_dto

import com.google.gson.annotations.SerializedName

data class SpaceXRocketDto(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("rocket_id")
    val rocketId: String? = null,

    @SerializedName("rocket_name")
    val rocketName: String? = null,

    @SerializedName("flickr_images")
    val images: List<String>? = null,

    @SerializedName("first_flight")
    val firstFlight: String? = null,

    @SerializedName("country")
    val country: String? = null,

    @SerializedName("cost_per_launch")
    val costPerLaunch: Int? = null,
)