package com.roblesdotdev.jetnotes.home.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.jetnotes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesTopAppBar(
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                stringResource(R.string.jetnotes),
                style = MaterialTheme.typography.titleMedium
            )
        },
        navigationIcon = {
            onBack?.let {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back to list",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun NotesTopAppBarPreview() {
    NotesTopAppBar(onBack = {})
}