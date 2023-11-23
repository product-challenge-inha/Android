package com.strayalpaca.tiffanyentropy

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.strayalpaca.tiffanyentropy.presentation.navigation.CollectionHistory
import com.strayalpaca.tiffanyentropy.presentation.navigation.HomeDest
import com.strayalpaca.tiffanyentropy.presentation.navigation.NotificationDest
import com.strayalpaca.tiffanyentropy.presentation.navigation.QrRecognition
import com.strayalpaca.tiffanyentropy.presentation.navigation.SensorMonitoringDest
import com.strayalpaca.tiffanyentropy.presentation.screen.collectionHistory.CollectionHistoryScreen
import com.strayalpaca.tiffanyentropy.presentation.screen.collectionHistory.CollectionHistoryViewModel
import com.strayalpaca.tiffanyentropy.presentation.screen.home.HomeScreen
import com.strayalpaca.tiffanyentropy.presentation.screen.home.HomeViewModel
import com.strayalpaca.tiffanyentropy.presentation.screen.notification.NotificationScreen
import com.strayalpaca.tiffanyentropy.presentation.screen.notification.NotificationViewModel
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.SensorMonitoringScreen
import com.strayalpaca.tiffanyentropy.presentation.screen.sensorMonitoring.SensorMonitoringViewModel
import com.strayalpaca.tiffanyentropy.presentation.screen.qrRecognition.QrRecognitionScreen
import com.strayalpaca.tiffanyentropy.presentation.screen.qrRecognition.QrRecognitionViewModel

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        modifier = modifier,
        startDestination = HomeDest.route,
    ) {
        composable(HomeDest.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                goToCollectionHistory = { navHostController.navigateToCollectionHistory() },
                goToNotification = { navHostController.navigateToNotification() },
                goToQrRecognition = { navHostController.navigateToQrRecognition() },
                goToSensorMonitoring = { navHostController.navigateToSensorMonitoring() },
                viewModel = viewModel
            )
        }

        composable(SensorMonitoringDest.route) {
            val viewModel = hiltViewModel<SensorMonitoringViewModel>()
            SensorMonitoringScreen(
                goBack = { navHostController.popBackStack() },
                viewModel = viewModel
            )
        }

        composable(NotificationDest.route) {
            val viewModel = hiltViewModel<NotificationViewModel>()
            NotificationScreen(
                goBack = { navHostController.popBackStack() },
                viewModel = viewModel
            )
        }

        composable(QrRecognition.route) {
            val viewModel = hiltViewModel<QrRecognitionViewModel>()
            QrRecognitionScreen(
                goBack = { navHostController.popBackStack() },
                viewModel = viewModel
            )
        }

        composable(CollectionHistory.route) {
            val viewModel = hiltViewModel<CollectionHistoryViewModel>()
            CollectionHistoryScreen(
                goBack = { navHostController.popBackStack() },
                viewModel = viewModel
            )
        }
    }
}

private fun NavHostController.navigateToNotification() = this.navigate(NotificationDest.route)

private fun NavHostController.navigateToSensorMonitoring() =
    this.navigate(SensorMonitoringDest.route)

private fun NavHostController.navigateToQrRecognition() = this.navigate(QrRecognition.route)

private fun NavHostController.navigateToCollectionHistory() = this.navigate(CollectionHistory.route)