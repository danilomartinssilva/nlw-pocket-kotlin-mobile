package com.rocketseat.nlw.nearby.ui.screen.viewModel

import com.rocketseat.nlw.nearby.data.model.NearbyRule

data class MarketDetailsUiState(
    val rules: List<NearbyRule>? = null,
    val coupon: String? = null
)
