package ru.mobile_broadcast.androidmeetupdiexample.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mobile_broadcast.androidmeetupdiexample.data.remote.SpaceXApi
import ru.mobile_broadcast.androidmeetupdiexample.di.annotations.BaseUrlQualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @BaseUrlQualifier
    @Provides
    fun provideBaseUrl(): String {
        return "https://api.spacexdata.com/v3/"
    }

    @Provides
    @Singleton
    fun provideSpaceXApi(
        @BaseUrlQualifier baseUrl: String
    ): SpaceXApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SpaceXApi::class.java)
    }
}