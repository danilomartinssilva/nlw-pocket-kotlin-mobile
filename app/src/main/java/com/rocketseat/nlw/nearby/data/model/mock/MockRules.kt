package com.rocketseat.nlw.nearby.data.model.mock

import com.rocketseat.nlw.nearby.data.model.NearbyRule

val mockRules = listOf(
    NearbyRule(
        id = "1",
        description = "Disponível até 31/12/2024",
        marketId = "xpto"
    ),
    NearbyRule(
        id = "2",
        description = "Válido apenas para o consumo no local",
        marketId = "xpto1"
    )
)