package com.strayalpaca.tiffanyentropy.presentation.component.template

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.ui.theme.TiffanyEntropyTheme

@Composable
fun LoadingFailView(
    modifier: Modifier = Modifier,
    retry: (() -> Unit)? = null
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.title_request_failure),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = R.string.description_request_failure),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            retry?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { retry() }) {
                    Text(text = stringResource(id = R.string.retry))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(
    name = "dark mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoadingFailViewPreview() {
    TiffanyEntropyTheme {
        Surface {
            LoadingFailView(modifier = Modifier.fillMaxSize(), retry = {})
        }
    }
}