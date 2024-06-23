package ru.mobile_broadcast.androidmeetupdiexample.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mobile_broadcast.androidmeetupdiexample.data.repository.SpaceXRepositoryImpl
import ru.mobile_broadcast.androidmeetupdiexample.domain.repository.SpaceXRepository
import ru.mobile_broadcast.androidmeetupdiexample.util.ResourceManager
import ru.mobile_broadcast.androidmeetupdiexample.util.ResourceManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindSpaceXRepository(impl: SpaceXRepositoryImpl): SpaceXRepository

    @Binds
    @Singleton
    abstract fun bindResourceManager(manager: ResourceManagerImpl): ResourceManager
}