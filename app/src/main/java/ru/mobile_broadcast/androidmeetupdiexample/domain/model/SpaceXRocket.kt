package ru.mobile_broadcast.androidmeetupdiexample.domain.model

data class SpaceXRocket(
    val id: Int,
    val rocketId: String,
    val rocketName: String,
    val imageUrl: String,
    val firstFlight: String,
    val country: String,
    val costPerLaunch: Int,
)