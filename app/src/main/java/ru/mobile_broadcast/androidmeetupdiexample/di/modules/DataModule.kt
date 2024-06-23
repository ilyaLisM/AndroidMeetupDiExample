package ru.mobile_broadcast.androidmeetupdiexample.di.modules

import dagger.Binds
import dagger.Module
import ru.mobile_broadcast.androidmeetupdiexample.data.repository.SpaceXRepositoryImpl
import ru.mobile_broadcast.androidmeetupdiexample.di.annotations.ApplicationScope
import ru.mobile_broadcast.androidmeetupdiexample.domain.repository.SpaceXRepository
import ru.mobile_broadcast.androidmeetupdiexample.util.ResourceManager
import ru.mobile_broadcast.androidmeetupdiexample.util.ResourceManagerImpl

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindSpaceXRepository(impl: SpaceXRepositoryImpl): SpaceXRepository

    @Binds
    @ApplicationScope
    abstract fun bindResourceManager(manager: ResourceManagerImpl): ResourceManager
}