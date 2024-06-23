package ru.mobile_broadcast.androidmeetupdiexample.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.mobile_broadcast.androidmeetupdiexample.R
import ru.mobile_broadcast.androidmeetupdiexample.data.mapper.AppMapper
import ru.mobile_broadcast.androidmeetupdiexample.data.remote.SpaceXApi
import ru.mobile_broadcast.androidmeetupdiexample.domain.QueryStatus
import ru.mobile_broadcast.androidmeetupdiexample.domain.model.SpaceXRocket
import ru.mobile_broadcast.androidmeetupdiexample.domain.repository.SpaceXRepository
import ru.mobile_broadcast.androidmeetupdiexample.util.ResourceManager
import java.io.IOException
import javax.inject.Inject

class SpaceXRepositoryImpl @Inject constructor(
    private val api: SpaceXApi,
    private val mapper: AppMapper,
    private val resourceManager: ResourceManager
) : SpaceXRepository {

    override suspend fun getRockets(): Flow<QueryStatus<List<SpaceXRocket>>> {
        return flow {
            emit(QueryStatus.Loading())
            try {
                val remoteRockets = api.getRockets()
                val modelRockets = mapper.mapListRocketDtoToListRocket(remoteRockets)
                emit(QueryStatus.Success(modelRockets))
            } catch (e: IOException) {
                emit(QueryStatus.Error(message = resourceManager.getString(R.string.internet_connection_error)))
            } catch (e: HttpException) {
                emit(QueryStatus.Error(message = resourceManager.getString(R.string.something_went_wrong)))
            }
        }
    }
}