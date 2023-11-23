package com.strayalpaca.tiffanyentropy.presentation.component.atom

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.ui.theme.TiffanyEntropyTheme

@Composable
fun NotificationIcon(
    modifier: Modifier = Modifier,
    imageResourceId: Int,
    onClick: () -> Unit,
    showDot : Boolean = false
) {
    Box(modifier = modifier.clickable { onClick() }.padding(12.dp)) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = imageResourceId),
            contentDescription = "notification"
        )
        if (showDot) {
            Image(
                modifier = Modifier.align(Alignment.TopEnd),
                painter = painterResource(id = R.drawable.baseline_circle_6),
                contentDescription = "notification exist",
                colorFilter = ColorFilter.tint(Color.Red)
            )
        }
    }

}

@Preview(showBackground = true)
@Preview(
    name="dark mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun NotificationIconPreview() {
    TiffanyEntropyTheme {
        Surface {
            NotificationIcon(
                modifier = Modifier.size(48.dp),
                imageResourceId = R.drawable.baseline_notifications_24,
                onClick = {},
                showDot = true
            )
        }
    }
}