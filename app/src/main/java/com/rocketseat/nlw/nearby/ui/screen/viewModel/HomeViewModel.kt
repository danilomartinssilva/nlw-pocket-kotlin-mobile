package com.rocketseat.nlw.nearby.ui.screen.viewModel

import NearbyRemoteDataSource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.rocketseat.nlw.nearby.ui.screen.uiEvents.HomeUiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.OnFetchCategories -> fetchCategories()
            is HomeUiEvent.OnFetchMarkets -> fetchMarkets(categoryId = event.categoryId)
        }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                NearbyRemoteDataSource.getCategories().fold(onSuccess = { categories ->
                    currentUiState.copy(categories = categories)
                }, onFailure = { _ ->
                    currentUiState.copy(categories = emptyList())
                })
            }
        }
    }

    private fun fetchMarkets(categoryId: String) {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                NearbyRemoteDataSource.getMarkets(categoryId = categoryId)
                    .fold(onSuccess = { markets ->
                        currentUiState.copy(markets = markets,
                            marketLocations = markets.map { m -> LatLng(m.latitude, m.longitude) })
                    }, onFailure = { _ ->
                        currentUiState.copy(markets = emptyList(), marketLocations = emptyList())
                    })
            }
        }
    }

}