package com.strayalpaca.tiffanyentropy.presentation.component.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.strayalpaca.tiffanyentropy.R

@Composable
fun <T> ItemSelectDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    title: String,
    itemList: List<T>,
    onItemSelect: (T) -> Unit,
    prevSelectedItem: T,
    getText: (T) -> String
) {
    var selectedItem by remember { mutableStateOf(prevSelectedItem) }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Surface(modifier = Modifier) {
            Column(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = onDismissRequest) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_close_24),
                        contentDescription = "close"
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 64.dp),
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Divider(
                    modifier = Modifier.fillMaxWidth(1f),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    columns = GridCells.Fixed(2)
                ) {
                    items(itemList.size) { index ->
                        if (selectedItem == itemList[index]) {
                            Button(
                                modifier = Modifier.height(40.dp),
                                onClick = {
                                    selectedItem = itemList[index]
                                }
                            ) {
                                Text(text = getText(itemList[index]))
                            }
                        } else {
                            Box(
                                modifier = Modifier
                                    .height(40.dp)
                                    .clickable {
                                        selectedItem = itemList[index]
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = getText(itemList[index]),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                Divider(
                    modifier = Modifier.fillMaxWidth(1f),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = onDismissRequest) {
                        Text(text = stringResource(id = R.string.cancel))
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    TextButton(onClick = {
                        onItemSelect(selectedItem)
                        onDismissRequest()
                    }) {
                        Text(text = stringResource(id = R.string.ok))
                    }
                }
            }
        }
    }
}