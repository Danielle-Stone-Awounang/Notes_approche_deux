package com.example.notesapp.feature_note.presentation.add_edit_note.components

import androidx.compose.runtime.State

data class NoteTextFieldState(
    val text: String = "",
    val hint:String = "",
    val isHintVisible : Boolean = true
)
