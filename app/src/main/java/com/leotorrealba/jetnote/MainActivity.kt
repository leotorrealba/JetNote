package com.leotorrealba.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leotorrealba.jetnote.data.NotesDataSource
import com.leotorrealba.jetnote.models.Note
import com.leotorrealba.jetnote.screens.NoteViewModel
import com.leotorrealba.jetnote.screens.NotesScreen
import com.leotorrealba.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel = noteViewModel)

                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
    val noteList = noteViewModel.getAllNotes()
    NotesScreen(
        notes = noteList,
        onRemoveNote = {
            noteViewModel.removeNote(it)
        },
        onAddNote = {
            noteViewModel.addNote(it)
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNoteTheme {

    }
}