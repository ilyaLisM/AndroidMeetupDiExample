package ru.mobile_broadcast.androidmeetupdiexample.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.mobile_broadcast.androidmeetupdiexample.di.annotations.ViewModelKey
import ru.mobile_broadcast.androidmeetupdiexample.presentation.main_screen.vm.MainViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}