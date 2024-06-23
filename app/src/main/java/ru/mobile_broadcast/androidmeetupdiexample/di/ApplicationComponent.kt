package ru.mobile_broadcast.androidmeetupdiexample.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.mobile_broadcast.androidmeetupdiexample.di.annotations.ApplicationScope
import ru.mobile_broadcast.androidmeetupdiexample.di.modules.ApiModule
import ru.mobile_broadcast.androidmeetupdiexample.di.modules.DataModule
import ru.mobile_broadcast.androidmeetupdiexample.di.modules.ViewModelModule
import ru.mobile_broadcast.androidmeetupdiexample.presentation.main_screen.ui.MainActivity

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        ApiModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}