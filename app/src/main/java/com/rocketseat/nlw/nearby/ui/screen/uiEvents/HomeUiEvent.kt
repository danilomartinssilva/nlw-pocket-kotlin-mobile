package com.rocketseat.nlw.nearby.ui.screen.uiEvents

sealed class HomeUiEvent {
    data class OnFetchMarkets(val categoryId: String) : HomeUiEvent()
    data object OnFetchCategories : HomeUiEvent()
}