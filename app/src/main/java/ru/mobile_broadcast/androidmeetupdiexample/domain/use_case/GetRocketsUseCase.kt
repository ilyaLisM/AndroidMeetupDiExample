package ru.mobile_broadcast.androidmeetupdiexample.domain.use_case

import kotlinx.coroutines.flow.Flow
import ru.mobile_broadcast.androidmeetupdiexample.domain.QueryStatus
import ru.mobile_broadcast.androidmeetupdiexample.domain.model.SpaceXRocket
import ru.mobile_broadcast.androidmeetupdiexample.domain.repository.SpaceXRepository
import javax.inject.Inject

class GetRocketsUseCase @Inject constructor(
    private val spaceXRepository: SpaceXRepository
) {

    suspend operator fun invoke(): Flow<QueryStatus<List<SpaceXRocket>>> {
        return spaceXRepository.getRockets()
    }
}