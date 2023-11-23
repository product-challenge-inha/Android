package com.strayalpaca.tiffanyentropy.presentation.component.block

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.ui.theme.TiffanyEntropyTheme

@Composable
fun HomeMenuItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    iconResourceId: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .border(2.dp, SolidColor(MaterialTheme.colorScheme.onSurfaceVariant),  shape = RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResourceId),
            contentDescription = title
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
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
fun HomeMenuItemPreview() {
    TiffanyEntropyTheme {
        Surface {
            HomeMenuItem(
                title = "센서값 모니터링",
                description = "센서값 모니터링에 대한 설명이 들어갑니다.",
                iconResourceId = R.drawable.baseline_show_chart_24,
                onClick = {}
            )
        }
    }
}