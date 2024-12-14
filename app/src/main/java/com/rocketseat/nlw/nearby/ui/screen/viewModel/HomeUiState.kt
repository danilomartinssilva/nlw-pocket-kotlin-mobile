package com.rocketseat.nlw.nearby.ui.screen.viewModel

import com.google.android.gms.maps.model.LatLng
import com.rocketseat.nlw.nearby.data.model.NearbyCategory
import com.rocketseat.nlw.nearby.data.model.NearbyMarket

data class HomeUiState(
    val categories: List<NearbyCategory>? = null,
    val markets: List<NearbyMarket>? = null,
    val marketLocations: List<LatLng>? = null
)
