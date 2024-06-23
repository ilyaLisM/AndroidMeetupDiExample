package ru.mobile_broadcast.androidmeetupdiexample.presentation

import ru.mobile_broadcast.androidmeetupdiexample.domain.model.SpaceXRocket


sealed class MainScreenUiState {

    object Init : MainScreenUiState()

    object Loading : MainScreenUiState()

    data class Success(val rocketsList: List<SpaceXRocket>) : MainScreenUiState()

    data class Error(val message: String) : MainScreenUiState()
}