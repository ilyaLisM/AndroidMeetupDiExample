package ru.mobile_broadcast.androidmeetupdiexample.presentation.main_screen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.mobile_broadcast.androidmeetupdiexample.domain.QueryStatus
import ru.mobile_broadcast.androidmeetupdiexample.domain.use_case.GetRocketsUseCase
import ru.mobile_broadcast.androidmeetupdiexample.presentation.MainScreenUiState
import ru.mobile_broadcast.androidmeetupdiexample.util.ResourceManager
import ru.mobile_broadcast.androidmeetupdiexample.util.toShortPriceName
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getRocketsUseCase: GetRocketsUseCase,
    private val resourceManager: ResourceManager,
) : ViewModel() {

    private val _state = MutableStateFlow<MainScreenUiState>(MainScreenUiState.Init)
    val state = _state.asStateFlow()

    fun getRockets() {
        viewModelScope.launch(Dispatchers.IO) {
            getRocketsUseCase()
                .onEach { result ->
                    when (result) {
                        is QueryStatus.Success -> {
                            _state.value = MainScreenUiState.Success(
                                rocketsList = result.data ?: emptyList()
                            )
                        }
                        is QueryStatus.Error -> {
                            _state.emit(
                                MainScreenUiState.Error(
                                    message = result.message ?: ""
                                )
                            )
                        }
                        is QueryStatus.Loading -> {
                            _state.emit(MainScreenUiState.Loading)
                        }
                    }
                }.launchIn(this)
        }
    }

    fun getFormattedPrice(costPerLaunch: Int): String {
        return costPerLaunch.toShortPriceName(resourceManager)
    }
}