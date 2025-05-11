package com.roblesdotdev.jetnotes.home.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.jetnotes.home.presentation.components.EmptyListText
import com.roblesdotdev.jetnotes.home.presentation.components.NotesTopAppBar
import com.roblesdotdev.jetnotes.ui.theme.JetNotesTheme

@Composable
fun ListScreen(viewModel: ListViewModel = hiltViewModel(), onNavigateToDetail: (String?) -> Unit) {
    val isLoading = viewModel.state.isLoading
    val isEmpty = viewModel.state.notes.isEmpty() && !isLoading
    Scaffold(
        topBar = {
            NotesTopAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNavigateToDetail(null)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (isEmpty) {
                item {
                    EmptyListText(onClick = {
                        onNavigateToDetail(null)
                    })
                }
            }
            items(viewModel.state.notes) { note ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable {
                        onNavigateToDetail(note.id)
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(note.title, style = MaterialTheme.typography.titleMedium)
                        Text(
                            note.description,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun ListScreenPreview() {
    JetNotesTheme {
        ListScreen(onNavigateToDetail = {})
    }
}