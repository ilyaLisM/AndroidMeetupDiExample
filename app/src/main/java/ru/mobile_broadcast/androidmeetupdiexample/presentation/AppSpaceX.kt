package ru.mobile_broadcast.androidmeetupdiexample.presentation

import android.app.Application
import ru.mobile_broadcast.androidmeetupdiexample.di.DaggerApplicationComponent

class AppSpaceX : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}