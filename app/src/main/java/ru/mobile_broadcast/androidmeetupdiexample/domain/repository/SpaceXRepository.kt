package ru.mobile_broadcast.androidmeetupdiexample.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.mobile_broadcast.androidmeetupdiexample.domain.QueryStatus
import ru.mobile_broadcast.androidmeetupdiexample.domain.model.SpaceXRocket

interface SpaceXRepository {

    suspend fun getRockets(): Flow<QueryStatus<List<SpaceXRocket>>>
}