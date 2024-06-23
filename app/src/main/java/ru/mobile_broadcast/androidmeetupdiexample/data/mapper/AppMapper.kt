package ru.mobile_broadcast.androidmeetupdiexample.data.mapper

import ru.mobile_broadcast.androidmeetupdiexample.data.remote.spacex_dto.SpaceXRocketDto
import ru.mobile_broadcast.androidmeetupdiexample.domain.model.SpaceXRocket
import javax.inject.Inject

class AppMapper @Inject constructor() {

    fun mapListRocketDtoToListRocket(rocketsDto: List<SpaceXRocketDto>): List<SpaceXRocket> {
        return rocketsDto.map { mapRocketDtoToRocket(it) }
    }

    private fun mapRocketDtoToRocket(rocketDto: SpaceXRocketDto): SpaceXRocket {
        return SpaceXRocket(
            id = rocketDto.id ?: DEFAULT_INT,
            rocketId = rocketDto.rocketId ?: EMPTY_STRING,
            rocketName = rocketDto.rocketName ?: EMPTY_STRING,
            imageUrl = rocketDto.images?.get(FIRST_INDEX) ?: EMPTY_STRING,
            firstFlight = rocketDto.firstFlight ?: EMPTY_STRING,
            country = rocketDto.country ?: EMPTY_STRING,
            costPerLaunch = rocketDto.costPerLaunch ?: DEFAULT_INT,
        )
    }

    companion object {
        private const val DEFAULT_INT = 0
        private const val EMPTY_STRING = ""
        private const val FIRST_INDEX = 0
    }
}