package com.roblesdotdev.jetnotes.home.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.jetnotes.home.presentation.components.NotesTopAppBar
import com.roblesdotdev.jetnotes.ui.theme.JetNotesTheme

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    onSave: () -> Unit,
    onDelete: () -> Unit,
) {

    val isLoading = viewModel.state.isLoading

    LaunchedEffect(viewModel.state.isSaved) {
        if (viewModel.state.isSaved) {
            onSave()
        }
    }

    Scaffold(
        topBar = {
            NotesTopAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Note title") },
                value = viewModel.state.title,
                onValueChange = { viewModel.onEvent(DetailEvent.OnChangeTitle(it)) },
                shape = RoundedCornerShape(8.dp)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Note description") },
                value = viewModel.state.description,
                onValueChange = { viewModel.onEvent(DetailEvent.OnChangeDescription(it)) },
                shape = RoundedCornerShape(8.dp)
            )
            Button(
                onClick = { viewModel.onEvent(DetailEvent.OnSave) }, modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = !isLoading,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(if (viewModel.state.id == null) "Create" else "Update")
            }
            if (viewModel.state.id != null) {
                TextButton(
                    onClick = {
                        viewModel.onEvent(DetailEvent.OnDelete)
                        onDelete()
                    },
                    enabled = !isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(
                        text = "Delete",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    JetNotesTheme {
        DetailScreen(
            onSave = {},
            onDelete = {}
        )
    }
}