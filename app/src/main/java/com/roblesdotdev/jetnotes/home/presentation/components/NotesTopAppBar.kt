package com.roblesdotdev.jetnotes.home.presentation.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.roblesdotdev.jetnotes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                stringResource(R.string.jetnotes),
                style = MaterialTheme.typography.titleMedium
            )
        },
    )
}