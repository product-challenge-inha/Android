package com.strayalpaca.tiffanyentropy.presentation.component.block

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot

@Composable
fun LineGraph(
    modifier : Modifier = Modifier,
    data : List<DataPoint>
) {
    LineGraph(
        modifier = modifier,
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
        onSelection = { xLine, points ->
            // Do whatever you want here
        }
    )
}