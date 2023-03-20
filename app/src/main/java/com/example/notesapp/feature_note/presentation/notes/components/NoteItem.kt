package com.example.notesapp.feature_note.presentation.notes.components

import android.text.Layout
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.notesapp.feature_note.domain.model.Note
import com.google.android.material.shape.AbsoluteCornerSize
import androidx.compose.ui.Modifier
import java.nio.file.Path

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier=Modifier(),
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () ->Unit
    ){
    Box(
        modifier = modifier
    ){
        Canvas(modifier=Modifier.fillMaxSize()){
            val clipath = Path().apply{
                lineTo(size.width - cutCornerSize.toPx(), of)
                lineTo(size.width, cutCornerSize.toPx() )
                lineTo(size.width, size.height)
                close()
            }

            clipath(clipath){
                drawRoundRect(
                    color = Color(note.color),
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
                drawRoundRect(
                    color = Color(ColorUtils.blendARGB(note.color, 0x000000,0.2f)),
                    topLeft= Offset(size.width - cutCornerSize.toPx(), -100f),
                    size = Size(cutCornerSize.toPx() + 100, cutCornerSize.toPx() + 100f),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }

        }

        Column (
            modifier =Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp)
                ){
            Text(text = note.title,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)

            Spacer(modifier = modifier.height(8.dp))

        }

        IconButton(
            onClick = onDeleteClick,
            modifier = Modifier.align(Layout.Alignment.BottomEnd)
        ){
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete note"
            )
        }

    }
}