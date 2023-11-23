package com.strayalpaca.tiffanyentropy.presentation.component.block

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.ui.theme.TiffanyEntropyTheme

@Composable
fun WeatherItem(
    modifier : Modifier,
    title : String,
    imageResourceId : Int,
    data : String
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title)
        Spacer(modifier = Modifier.height(4.dp))
        Image(modifier = Modifier.size(48.dp), painter = painterResource(id = imageResourceId), contentDescription = title)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = data)
    }
}

@Preview(showBackground = true)
@Preview(
    name="dark mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SomePreview() {
    TiffanyEntropyTheme {
        Surface {
            Row(Modifier.fillMaxWidth()) {
                WeatherItem(modifier = Modifier.weight(1f), title = "습도", imageResourceId = R.drawable.baseline_water_drop_24, data = "--")
                WeatherItem(modifier = Modifier.weight(1f), title = "습도", imageResourceId = R.drawable.baseline_water_drop_24, data = "--")
                WeatherItem(modifier = Modifier.weight(1f), title = "습도", imageResourceId = R.drawable.baseline_water_drop_24, data = "--")
            }
        }
    }
}