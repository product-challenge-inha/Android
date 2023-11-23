package com.strayalpaca.tiffanyentropy.presentation.screen.home

import android.Manifest
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.presentation.component.atom.NotificationIcon
import com.strayalpaca.tiffanyentropy.presentation.component.block.HomeMenuItem
import com.strayalpaca.tiffanyentropy.presentation.screen.home.model.HomeMenu

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    goToSensorMonitoring: () -> Unit,
    goToNotification: () -> Unit,
    goToQrRecognition: () -> Unit,
    goToCollectionHistory: () -> Unit,
    viewModel: HomeViewModel
) {
    val showNotificationDot by viewModel.showNotificationDot.collectAsState()
    val context = LocalContext.current

    val homeMenuList = remember {
        listOf(
            HomeMenu(
                titleResourceId = R.string.title_sensor_monitoring,
                descriptionTextResourceId = R.string.description_sensor_monitoring,
                imageResourceId = R.drawable.baseline_show_chart_24,
                onClick = goToSensorMonitoring
            ),
            HomeMenu(
                titleResourceId = R.string.title_qr_recognition,
                descriptionTextResourceId = R.string.description_qr_recognition,
                imageResourceId = R.drawable.baseline_qr_code_scanner_24,
                onClick = goToQrRecognition
            ),
            HomeMenu(
                titleResourceId = R.string.title_confirm_collection_history,
                descriptionTextResourceId = R.string.description_confirm_collection_history,
                imageResourceId = R.drawable.baseline_search_24,
                onClick = goToCollectionHistory
            ),
        )
    }

    val launcher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission(),
            onResult = { isGranted ->
                if (!isGranted) {
                    Toast.makeText(context, context.getString(R.string.need_push_notification_permission), Toast.LENGTH_SHORT).show()
                }
            }
        )

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    HomeScreenUi(
        modifier = modifier,
        goToNotification = goToNotification,
        menuList = homeMenuList,
        showNotificationDot = showNotificationDot
    )
}

@Composable
fun HomeScreenUi(
    modifier: Modifier = Modifier,
    goToNotification: () -> Unit,
    menuList: List<HomeMenu>,
    showNotificationDot: Boolean = false
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium
            )

            NotificationIcon(
                imageResourceId = R.drawable.baseline_notifications_24,
                onClick = { goToNotification() },
                showDot = showNotificationDot
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        for (menu in menuList) {
            HomeMenuItem(
                title = stringResource(id = menu.titleResourceId),
                description = stringResource(id = menu.descriptionTextResourceId),
                iconResourceId = menu.imageResourceId,
                onClick = menu.onClick
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}