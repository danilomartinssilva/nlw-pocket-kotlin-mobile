package com.rocketseat.nlw.nearby.data.model.mock

import com.rocketseat.nlw.nearby.data.model.NearbyMarket
import com.rocketseat.nlw.nearby.data.model.NearbyRule

val mockMarkets = listOf(
    NearbyMarket(
        id = "12345",
        categoryId = "67890",
        name = "Supermercado Perto de Você",
        description = "O melhor supermercado da região com ofertas incríveis todos os dias!",
        coupons = 20,
        /*     rules = listOf(NearbyRule("1", description = "Válido até o dia 25/12", marketId ="456456" ),
                 NearbyRule("2", description = "Disponível apenas para consumo local", marketId ="4564562" )),
          */   longitude = -46.633308,
        latitude = -23.55052,
        address = "Avenida Paulista, 1000, São Paulo - SP",
        phone = "(11) 1234-5678",
        cover = "https://plus.unsplash.com/premium_photo-1693262738354-b025d4005eb1?q=80&w=2670&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    ),
    NearbyMarket(
        id = "45678",
        categoryId = "11223",
        name = "Restaurante Sabor Caseiro",
        description = "Deliciosas refeições caseiras preparadas com ingredientes frescos.",
        coupons = 15,
        //  rules = listOf(NearbyRule("1", description = "Válido até o dia 25/12", marketId ="456456" )),

        longitude = -48.8566,
        latitude = -26.3044,
        address = "Praça das Nações, 150, Florianópolis - SC",
        phone = "(48) 3456-7890",
        cover = "https://plus.unsplash.com/premium_photo-1693262738354-b025d4005eb1?q=80&w=2670&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    NearbyMarket(
        id = "65432",
        categoryId = "99887",
        name = "Bistrô Gourmet",
        description = "Experimente pratos sofisticados com um toque de inovação.",
        coupons = 25,
        //   rules = listOf(NearbyRule("1", description = "Válido até o dia 25/12", marketId ="456456" )),
        longitude = -47.8825,
        latitude = -15.7942,
        address = "Setor Gourmet, 120, Brasília - DF",
        phone = "(61) 9988-7766",
        cover = "https://images.unsplash.com/photo-1515037609796-8a12ca603d7d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGNodXJyYXNjb3xlbnwwfHwwfHx8MA%3D%3D"
    )

)