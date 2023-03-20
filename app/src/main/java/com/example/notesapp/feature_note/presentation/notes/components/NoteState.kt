package com.example.notesapp.feature_note.presentation.notes.components

import com.example.notesapp.feature_note.domain.model.Note
import com.example.notesapp.feature_note.domain.util.NoteOrder
import com.example.notesapp.feature_note.domain.util.OrderType

data class NoteState(
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisibile: Boolean = false
)
