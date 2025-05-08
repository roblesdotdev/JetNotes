package com.roblesdotdev.jetnotes.home.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.jetnotes.home.presentation.list.components.EmptyListText
import com.roblesdotdev.jetnotes.ui.theme.JetNotesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(viewModel: ListViewModel = hiltViewModel(), onAddNote: () -> Unit) {
    val isEmpty = viewModel.state.notes.isEmpty()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Simple Crud", style = MaterialTheme.typography.titleMedium) },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (isEmpty) {
                EmptyListText(onClick = onAddNote)
            }
        }
    }
}



@Preview
@Composable
private fun ListScreenPreview() {
    JetNotesTheme {
        ListScreen(onAddNote = {})
    }
}