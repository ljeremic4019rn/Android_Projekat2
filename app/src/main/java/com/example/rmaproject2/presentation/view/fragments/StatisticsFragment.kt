package com.example.rmaproject2.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.rmaproject2.R
import com.example.rmaproject2.presentation.contract.NoteContract
import com.example.rmaproject2.presentation.viewModels.NotesViewModel

import org.koin.androidx.viewmodel.ext.android.sharedViewModel



class StatisticsFragment : Fragment() {

    private val noteViewModel: NoteContract.ViewModel by sharedViewModel<NotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_statistics, container, false)
        view.findViewById<ComposeView>(R.id.statisticsComposeView).setContent {
            Start(noteViewModel)
        }
        return view
    }
}
@Composable
fun Start(
    noteViewModel: NoteContract.ViewModel,
    modifier: Modifier = Modifier



) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Note statistics in the last 5 days",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.padding(30.dp))

        Canvas(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

//
//            drawRect(
//                color = Color.Blue,
//                topLeft = Offset(canvasWidth / 4f, 220f),
//                size = Size(60f, noteViewModel.statisticsHolder.getDay1()),
//
//            )
//            drawRect(
//                color = Color.Blue,
//                topLeft = Offset(canvasWidth / 4f + 100f, 222f),
//                size = Size(60f, noteViewModel.statisticsHolder.getDay2())
//            )
//            drawRect(
//                color = Color.Blue,
//                topLeft = Offset(canvasWidth / 4f + 200f, 222f),
//                size = Size(60f, noteViewModel.statisticsHolder.getDay3())
//            )
//            drawRect(
//                color = Color.Blue,
//                topLeft = Offset(canvasWidth / 4f + 300f, 222f),
//                size = Size(60f, noteViewModel.statisticsHolder.getDay4())
//            )
//            drawRect(
//                color = Color.Blue,
//                topLeft = Offset(canvasWidth / 4f + 400f, 222f),
//                size = Size(60f, noteViewModel.statisticsHolder.getDay5())
//            )

            drawLine(
                color = Color.Red,
                strokeWidth = 50f,
                start = Offset((canvasHeight / 4L),  (canvasHeight / 2L)),
                end = Offset((canvasHeight / 4L),  (canvasHeight / 2L) - noteViewModel.statisticsHolder.gettDay1()),
            )

            drawLine(
                color = Color.Red,
                strokeWidth = 50f,
                start = Offset((canvasHeight / 4L + 100L),  (canvasHeight / 2L)),
                end = Offset((canvasHeight / 4L) + 100L,  (canvasHeight / 2L) - noteViewModel.statisticsHolder.gettDay2()),
            )

            drawLine(
                color = Color.Red,
                strokeWidth = 50f,
                start = Offset((canvasHeight / 4L) + 200L,  (canvasHeight / 2L)),
                end = Offset((canvasHeight / 4L) + 200L,  (canvasHeight / 2L) - noteViewModel.statisticsHolder.gettDay3()),
            )

            drawLine(
                color = Color.Red,
                strokeWidth = 50f,
                start = Offset((canvasHeight / 4L) + 300L,  (canvasHeight / 2L)),
                end = Offset((canvasHeight / 4L) + 300L,  (canvasHeight / 2L) - noteViewModel.statisticsHolder.gettDay4()),
            )

            drawLine(
                color = Color.Red,
                strokeWidth = 50f,
                start = Offset((canvasHeight / 4L) + 400L,  (canvasHeight / 2L)),
                end = Offset((canvasHeight / 4L) + 400L,  (canvasHeight / 2L) - noteViewModel.statisticsHolder.gettDay5()),
            )
        }
    }

}