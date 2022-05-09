package com.leotorrealba.jetnote.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.leotorrealba.jetnote.data.NotesDataSource
import com.leotorrealba.jetnote.models.Note

class NoteViewModel: ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }
}