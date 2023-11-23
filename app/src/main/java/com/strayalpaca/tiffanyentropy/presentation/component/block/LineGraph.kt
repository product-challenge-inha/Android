package com.strayalpaca.tiffanyentropy.presentation.component.block

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.madrapps.plot.line.LinePlot
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph

@Composable
fun LineGraph(
    modifier : Modifier = Modifier,
    data : List<DataPoint>
) {
    LineGraph(
        plot = LinePlot(
            listOf(
                LinePlot.Line(
                    data,
                    LinePlot.Connection(color = Color.Red),
                    LinePlot.Intersection(color = Color.Magenta),
                    LinePlot.Highlight(color = Color.Yellow),
                )
            ),
            grid = LinePlot.Grid(Color.Gray, steps = 4),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        onSelection = { xLine, points ->
            // Do whatever you want here
        }
    )
}