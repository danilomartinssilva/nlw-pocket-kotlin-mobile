package com.rocketseat.nlw.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.rocketseat.nlw.nearby.data.model.NearbyMarket
import com.rocketseat.nlw.nearby.ui.screen.HomeScreen
import com.rocketseat.nlw.nearby.ui.screen.SplashScreen
import com.rocketseat.nlw.nearby.ui.screen.WelcomeScreen
import com.rocketseat.nlw.nearby.ui.screen.market_details.MarketDetailsScreen
import com.rocketseat.nlw.nearby.ui.screen.market_details.MarketDetailsViewModel
import com.rocketseat.nlw.nearby.ui.screen.qrcode_scanner.QRCodeScannerScreen
import com.rocketseat.nlw.nearby.ui.screen.route.Home
import com.rocketseat.nlw.nearby.ui.screen.route.QRCodeScanner
import com.rocketseat.nlw.nearby.ui.screen.route.Splash
import com.rocketseat.nlw.nearby.ui.screen.route.Welcome
import com.rocketseat.nlw.nearby.ui.screen.uiEvents.MarketDetailsUiEvent
import com.rocketseat.nlw.nearby.ui.screen.viewModel.HomeViewModel
import com.rocketseat.nlw.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()

                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketDetailsViewModel by viewModels<MarketDetailsViewModel>()
                val marketDetailsUIState by marketDetailsViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            modifier = Modifier.fillMaxSize(),
                            onNavigationToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }

                    composable<Welcome> {
                        WelcomeScreen(onNavigationToHome = {
                            navController.navigate(Home)
                        })
                    }

                    composable<Home> {
                        HomeScreen(onNavigationToMarketDetails = { selectedMarket ->
                            navController.navigate(selectedMarket)
                        }, uiState = homeUiState, onEvent = homeViewModel::onEvent)
                    }

                    composable<NearbyMarket> {
                        val selectedMarket = it.toRoute<NearbyMarket>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            uiState = marketDetailsUIState,
                            onEvent = marketDetailsViewModel::onEvent,
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            onNavigateToQRCodeScanner = {
                                navController.navigate(QRCodeScanner)
                            }
                        )
                    }

                    composable<QRCodeScanner> {
                        QRCodeScannerScreen(
                            onCompletedScan = { qrCodeContent ->
                                if (qrCodeContent.isNotEmpty()) {
                                    marketDetailsViewModel.onEvent(
                                        MarketDetailsUiEvent.OnFetchCoupon(
                                            qrCodeContent
                                        )
                                    )
                                    navController.popBackStack()
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NearbyTheme {

    }
}